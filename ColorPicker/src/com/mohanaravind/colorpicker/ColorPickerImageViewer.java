/**
 * 
 */
package com.mohanaravind.colorpicker;

import com.mohanaravind.utility.GlobalApplicationState;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff.Mode;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * @author Aravind
 *
 */
public class ColorPickerImageViewer extends SurfaceView implements Runnable{

	//Private fields
	private Thread _th = null;
	private SurfaceHolder _sHolder = null;
	private boolean _blnStartDraw = false;
	private float _X = 0;
	private float _Y = 0;
	
	
	/**
	 * Constructor
	 * @param context
	 */
	public ColorPickerImageViewer(Context context) {
		super(context);
		this._sHolder = super.getHolder();
		this._X = super.getWidth() / 2;
		this._Y = super.getHeight() / 2;
	}
	
	/**
	 * Gets triggered when on resume method of the activity gets triggered
	 */
	public void onResume(){
		_blnStartDraw = true;
		
		_th = new Thread(this);
		_th.start();	
	}
	
	/**
	 * Gets triggered when on pause method of the activity gets triggered
	 */
	public void onPause(){
		_blnStartDraw = false;
		
		
		while(true){
			try{
				_th.join();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			break;
		}
				
		_th = null;
		
	}

	@Override
	public void run() {
		//Get the bitmap which needs to be drawn
		Bitmap bmColorExtractor = BitmapFactory.decodeResource(getResources(), R.drawable.colorextractor);
		
		this.setZOrderOnTop(true);
		_sHolder.setFormat(PixelFormat.TRANSPARENT);
		
		while(_blnStartDraw){
			//Check whether the canvas is ready
			if(!_sHolder.getSurface().isValid()){
				continue;
			}
						
			//Draw the color extractor image onto the canvas
			drawOnCanvas(bmColorExtractor);
		}
		
	}
		
	
	/**
	 * Draws the picture onto the canvas
	 * @param bmDrawable
	 */	
	private void drawOnCanvas(Bitmap bmDrawable){
		//this.setZOrderOnTop(true);
		//_sHolder.setFormat(PixelFormat.TRANSPARENT);
		
		//Lock the canvas
		Canvas c = _sHolder.lockCanvas();
					
		//Clear the canvas
		c.drawColor(0, Mode.CLEAR);
					
		//Check whether there was a image which was supposed to be displayed
		if(GlobalApplicationState.getInstance().getURI() != null)
			//Draw the bitmap
			c.drawBitmap(bmDrawable, _X - (bmDrawable.getWidth()/2), _Y - (bmDrawable.getHeight()/2), null);
		
		//Unlock the canvas 
		_sHolder.unlockCanvasAndPost(c);
		
	}
	
	/**
	 * Sets the X position
	 * @param X
	 */
	public void setX(float X){
		this._X = X;		
	}
	
	/**
	 * Sets the Y position
	 * @param Y
	 */
	public void setY(float Y){
		this._Y = Y;
	}
	
	
	public float getX(){
		return this._X;
	}
	
	public float getY(){
		return this._Y;
	}
	
}
