/**
 * 
 */
package com.mohanaravind.core;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;

import com.mohanaravind.entity.RGB;



/**
 * @author Aravind
 *
 */
public class ImageProcessor  {
	
	private Bitmap _biImage = null;
	
	/**
	 * Constructor which takes Buffered image
	 * @param biImage
	 */
	public ImageProcessor(Bitmap biImage){
		this._biImage = biImage;
	}
	
	/**
	 * Constructor which takes the path of the image
	 * @param biImage
	 */
	public ImageProcessor(String strFilePath){
		//Declarations
		Bitmap image = null;
		
		try {
			image = BitmapFactory.decodeFile(strFilePath);
		} catch(Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this._biImage = image;		
	}
	
	/**
	 * Gets the height of the image in pixels
	 * @return Integer
	 */
	public int getImageHeight(){
		return this._biImage.getHeight();
	}
	
	
	/**
	 * Gets the width of the image in pixels
	 * @return Integer
	 */
	public int getImageWidth(){
		return this._biImage.getWidth();
	}
	
	
	/**
	 * Gets the Red, Green, Blue values of the image  
	 * @param biImage
	 * @return RGB
	 * RGB object contains the different values for Red, green and blue intensity
	 */
	public RGB getRGB(int intX, int intY){
		//Declarations
		RGB objRGB = new RGB();
		
		try{
			// Getting pixel color by position 
			int clr = this._biImage.getPixel(intX, intY);		
			
			//Set the pixel value
			objRGB.setPixel(clr);
								
			//Set the different color intensity
			objRGB.setRed(Color.red(clr));
			objRGB.setGreen(Color.green(clr));
			objRGB.setBlue(Color.blue(clr));
		}catch(IllegalArgumentException e){
			e.printStackTrace();
		}
				
		//Set the pixel co-ordinates
		objRGB.setX(intX);
		objRGB.setY(intY);
		
		return objRGB;
	}
	
			
}
