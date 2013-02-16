package com.mohanaravind.colorpicker;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import android.widget.Toast;

import com.mohanaravind.core.ImageProcessor;
import com.mohanaravind.entity.RGB;
import com.mohanaravind.utility.GlobalApplicationState;
import com.mohanaravind.utility.Utility;

public class ColorPickerActivity extends Activity {

	// Fields
	private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
	private static final int SELECT_PICTURE = 1;

	// Contains the path of the selected image from the gallery
	// private String _SelectedImagePath = null;

	private ImageView _imgViewer = null;
	private ColorPickerImageViewer _objColorPickerImageViewer = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onPause()
	 */
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();

		_objColorPickerImageViewer.onPause();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onResume()
	 */
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

		_objColorPickerImageViewer.onResume();
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// Handle the back button
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			// Ask the user if they want to quit
			new AlertDialog.Builder(this)
					.setIcon(android.R.drawable.ic_dialog_alert)
					.setTitle("Exit")
					.setMessage("Are you sure you want to leave?")
					.setNegativeButton(android.R.string.cancel, null)
					.setPositiveButton(android.R.string.ok,
							new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									// Clears the URI
									GlobalApplicationState.getInstance()
											.clearURI();
									// Exit the activity
									ColorPickerActivity.this.finish();
								}
							}).show();

			// Say that we've consumed the event
			return true;
		}

		return super.onKeyDown(keyCode, event);
	}

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Sets the application to full screen mode
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		// Set the content view as defined in the xml
		setContentView(R.layout.main);

		constructViewer();

		// Display the captured image onto the layout
		displayCapturedImage();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.options, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		try {
			if (item.getItemId() == R.id.about) {
				// Display the about page
				startActivity(new Intent(this, About.class));
			}
		} catch (Exception e) {
			Toast tstException = Toast.makeText(this,
					"Error while displaying the about page\n" + e.getMessage(),
					Toast.LENGTH_LONG);
			tstException.show();

		}

		return true;
	}

	/**
	 * Constructs the viewer related controls
	 */
	private void constructViewer() {
		try {
			// Get the viewer layout
			FrameLayout flViewer = (FrameLayout) findViewById(R.id.flViewer);

			// Create the camera controls
			ImageButton btnCamera = new ImageButton(this);
			btnCamera.setImageResource(R.drawable.camera);

			FrameLayout.LayoutParams lpCamera = new FrameLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			lpCamera.setMargins(0, 20, 20, 0);
			lpCamera.gravity = Gravity.RIGHT;

			// Set the layout parameters
			btnCamera.setLayoutParams(lpCamera);

			// Set the onclick listener
			btnCamera.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					// Clear the URI
					GlobalApplicationState.getInstance().clearURI();
					captureImage();
				}
			});

			// Create the gallery controls
			ImageButton btnGallery = new ImageButton(this);
			btnGallery.setImageResource(R.drawable.gallery);

			FrameLayout.LayoutParams lpGallery = new FrameLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			lpGallery.setMargins(20, 20, 0, 0);
			lpGallery.gravity = Gravity.LEFT;

			// Set the layout parameters
			btnGallery.setLayoutParams(lpGallery);

			// Set the onclick listener
			btnGallery.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					// Open up the gallery
					// in onCreate or any event where your want the user to
					// select a file
					Intent intent = new Intent();
					intent.setType("image/*");
					intent.setAction(Intent.ACTION_GET_CONTENT);
					startActivityForResult(
							Intent.createChooser(intent, "Select Picture"),
							SELECT_PICTURE);
					// Clear the URI
					GlobalApplicationState.getInstance().clearURI();
				}
			});

			// Create a new image viewer
			_imgViewer = new ImageView(this);
			_imgViewer.setScaleType(ScaleType.FIT_XY);
			_imgViewer.setImageResource(R.drawable.bg);
			flViewer.addView(_imgViewer);

			_objColorPickerImageViewer = new ColorPickerImageViewer(this);

			// Set the on touch listener
			_objColorPickerImageViewer
					.setOnTouchListener(new OnTouchListener() {

						@Override
						public boolean onTouch(View v, MotionEvent event) {
							/*
							 * try { Thread.sleep(50); } catch
							 * (InterruptedException e) { e.printStackTrace(); }
							 */

							// Check whether there is any picture selected
							if (GlobalApplicationState.getInstance().getURI() != null) {								
								_objColorPickerImageViewer.setX(event.getX());
								_objColorPickerImageViewer.setY(event.getY());

								// Start analyzing the image
								analyzeImage(event.getX(), event.getY());																
							}

							return false;
						}
					});

			// Add the view
			flViewer.addView(_objColorPickerImageViewer);

			// Add the camera button to the view
			flViewer.addView(btnCamera);
			// Add the gallery button to the view
			flViewer.addView(btnGallery);

		} catch (Exception e) {
			Toast tstException = Toast.makeText(this,
					"Error while constructing the viewer\n" + e.getMessage(),
					Toast.LENGTH_LONG);

			tstException.show();
		}

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		try {
			// Get the image name textview
			TextView tvColorName = (TextView) findViewById(R.id.tvColorName);
			TextView tvHex = (TextView) findViewById(R.id.tvHex);
			// Set the color
			ImageView imgLens = (ImageView) findViewById(R.id.imgLens);

			if (resultCode == RESULT_OK) {
				if (requestCode == SELECT_PICTURE) {
					Uri selectedImageUri = data.getData();
					// Set the uri
					GlobalApplicationState.getInstance().setURI(
							selectedImageUri);
					displayCapturedImage();

				} else if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
					displayCapturedImage();
				}
			} else if (resultCode == RESULT_CANCELED) {
				// User cancelled the image capture
				// _imgViewer.setVisibility(View.INVISIBLE);
				_imgViewer.setImageResource(R.drawable.bg);
				_imgViewer.setScaleType(ScaleType.FIT_XY);
				// Set the hex value
				tvHex.setText("Hex");
				tvColorName.setText("ColorName");
				imgLens.setBackgroundColor(Color.BLACK);
				// Clear the URI
				GlobalApplicationState.getInstance().clearURI();
			} else {
				// Image capture failed, advise user
				// _imgViewer.setVisibility(View.INVISIBLE);
				_imgViewer.setImageResource(R.drawable.bg);
				_imgViewer.setScaleType(ScaleType.FIT_XY);
				// Set the hex value
				tvHex.setText("Hex");
				tvColorName.setText("ColorName");
				imgLens.setBackgroundColor(Color.BLACK);
				// Clear the URI
				GlobalApplicationState.getInstance().clearURI();
			}
		} catch (Exception e) {
			Toast tstException = Toast.makeText(this,
					"Error while returning from camera\n" + e.getMessage(),
					Toast.LENGTH_LONG);
			tstException.show();
		}

	}

	/**
	 * Displays the captured image to the user
	 */
	private void displayCapturedImage() {
		Bitmap b = null;

		try {
			Uri fileURI = GlobalApplicationState.getInstance().getURI();

			if (fileURI != null) {
				b = BitmapFactory.decodeFile(fileURI.getPath());

				// Check if its null
				if (b == null)
					b = BitmapFactory.decodeFile(getImagePath(fileURI));

				_imgViewer.setScaleType(ScaleType.FIT_XY);

				_imgViewer.setImageBitmap(b);

				// Display a toast asking the user to touch to get the pixel
				// color
				Toast tstMessage = Toast.makeText(this,
						"Touch any point to identify its color",
						Toast.LENGTH_SHORT);

				tstMessage.show();

				// Analyze the image with its last position
				analyzeImage(_objColorPickerImageViewer.getX(),
						_objColorPickerImageViewer.getY());

			}

		} catch (Exception e) {
			Toast tstException = Toast.makeText(
					this,
					"Error while displaying the captured image\n"
							+ e.getMessage(), Toast.LENGTH_LONG);
			tstException.show();
		}

	}

	/**
	 * Gets triggered when the user clicks on the camera button
	 * 
	 * @param view
	 */
	private void captureImage() {
		try {

			Intent inCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

			Uri fileUri = Utility.getOutputMediaFileUri(
					Utility.MEDIA_TYPE_IMAGE, "ColorPicker");

			// Store it in the global state
			GlobalApplicationState.getInstance().setURI(fileUri);

			// Make the camera intent to store it in the desired location
			inCamera.putExtra(MediaStore.EXTRA_OUTPUT, fileUri); // set the
																	// image
																	// file name

			// start the image capture Intent
			startActivityForResult(inCamera,
					CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
		} catch (Exception e) {
			Toast tstException = Toast.makeText(this,
					"Error while starting the camera\n" + e.getMessage(),
					Toast.LENGTH_LONG);
			tstException.show();
		}
	}

	/**
	 * Analyzes the image which is getting displayed onto the viewer
	 * 
	 * @param x
	 * @param y
	 */
	private void analyzeImage(float x, float y) {
		Bitmap bmImageToAnalyze = null;

		try {

			Uri fileURI = GlobalApplicationState.getInstance().getURI();

			if (fileURI != null) {
				bmImageToAnalyze = BitmapFactory.decodeFile(fileURI.getPath());

				// Check if its null
				if (bmImageToAnalyze == null)
					bmImageToAnalyze = BitmapFactory
							.decodeFile(getImagePath(fileURI));

				// Get the coordinates which maps to the actual image
				int intX = (int) (((float) bmImageToAnalyze.getWidth() / (float) _imgViewer
						.getWidth()) * x);
				int intY = (int) (((float) bmImageToAnalyze.getHeight() / (float) _imgViewer
						.getHeight()) * y);

				// Check the X and Y for safety
				if (intX > bmImageToAnalyze.getWidth())
					intX = bmImageToAnalyze.getWidth();

				if (intY > bmImageToAnalyze.getHeight())
					intY = bmImageToAnalyze.getHeight();

				// Process the image
				ImageProcessor objImageProcessor = new ImageProcessor(
						bmImageToAnalyze);

				// Get the RGB value of the image
				RGB objRGB = objImageProcessor.getRGB(intX, intY);

				// Set the color details
				setColorDetails(objRGB);
			}
		} catch (Exception e) {
			Toast tstException = Toast.makeText(this,
					"Error while analyzing the image\n" + e.getMessage(),
					Toast.LENGTH_LONG);
			tstException.show();
		}

	}

	/**
	 * Gets the image path
	 * 
	 * @param uri
	 * @return
	 */
	public String getImagePath(Uri uri) {
		String[] projection = { MediaStore.Images.Media.DATA };
		Cursor cursor = managedQuery(uri, projection, null, null, null);
		int column_index = cursor
				.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
		cursor.moveToFirst();
		return cursor.getString(column_index);
	}

	/**
	 * Sets the color details with the various RGB informations
	 */
	private void setColorDetails(RGB objRGB) {
		// Declarations

		try {

			// Get the image name textview
			TextView tvColorName = (TextView) findViewById(R.id.tvColorName);
			TextView tvHex = (TextView) findViewById(R.id.tvHex);

			String strHex = "";
			String strColorName = "";

			// Set the color
			ImageView imgLens = (ImageView) findViewById(R.id.imgLens);
			imgLens.setBackgroundColor(objRGB.getPixel());

			// Get the hex representation of the color
			strHex = ColorNameProvider.getHexStringFromRGB(objRGB.getRed(),
					objRGB.getGreen(), objRGB.getBlue());

			// Set the hex value
			tvHex.setText("Hex value: " + strHex);

			// Get the closest resembling color name
			/*
			 * strColorName = ColorNameProvider.getColorName(objRGB.getRed(),
			 * objRGB.getGreen(), objRGB.getBlue());
			 */
			strColorName = ColorNameProvider.getColorName(
					Color.red(objRGB.getPixel()),
					Color.green(objRGB.getPixel()),
					Color.blue(objRGB.getPixel()));

			// Get the color name
			tvColorName.setText(strColorName);

			/*
			 * TextView tvRedValue = (TextView)findViewById(R.id.tvRedValue);
			 * TextView tvGreenValue =
			 * (TextView)findViewById(R.id.tvGreenValue); TextView tvBlueValue =
			 * (TextView)findViewById(R.id.tvBlueValue);
			 * 
			 * //Set the RGB values
			 * tvRedValue.setText(Integer.toString(objRGB.getRed()));
			 * tvBlueValue.setText(Integer.toString(objRGB.getBlue()));
			 * tvGreenValue.setText(Integer.toString(objRGB.getGreen()));
			 */

		} catch (Exception e) {
			Toast tstException = Toast.makeText(this,
					"Error while setting color details\n" + e.getMessage(),
					Toast.LENGTH_LONG);
			tstException.show();

		}

	}

}