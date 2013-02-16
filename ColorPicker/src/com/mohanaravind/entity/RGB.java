/**
 * 
 */
package com.mohanaravind.entity;

/**
 * @author Aravind
 *
 */
public class RGB {
	
	private int _intRed = 0;
	private int _intBlue = 0;
	private int _intGreen = 0;
	
	private int _intPixelValue = 0;
	
	/**
	 * Absolute positions
	 */
	private Integer _intX = Integer.MIN_VALUE;
	private Integer _intY = Integer.MIN_VALUE;
	
	/**
	 * Relative positions
	 */
	private Integer _intRelX = Integer.MIN_VALUE;
	private Integer _intRelY = Integer.MIN_VALUE;
	
	private RGB _objRelRGB = null;
	
	
	
	//Default contstructor
	public RGB(){
		
	}
	
	//Constructor
	public RGB(int intRed, int intBlue, int intGreen){
		this._intRed = intRed;
		this._intBlue = intBlue;
		this._intGreen = intGreen;
	}
	
	
	/**
	 * @return the _intRed
	 */
	public int getRed() {
		return _intRed;
	}
	/**
	 * @param _intRed the _intRed to set
	 */
	public void setRed(int intRed) {
		this._intRed = intRed;
	}
	/**
	 * @return the _intBlue
	 */
	public int getBlue() {
		return _intBlue;
	}
	
	/**
	 * @return the Pixel value
	 */
	public int getPixel() {
		return _intPixelValue;
	}
	
	/**Sets the Pixel value
	 * @param intPixel 
	 */
	public void setPixel(int intPixel) {
		this._intPixelValue = intPixel;
	}
	
	/**
	 * @param _intBlue the _intBlue to set
	 */
	public void setBlue(int intBlue) {
		this._intBlue = intBlue;
	}
	/**
	 * @return the _intGreen
	 */
	public int getGreen() {
		return _intGreen;
	}
	/**
	 * @param _intGreen the _intGreen to set
	 */
	public void setGreen(int intGreen) {
		this._intGreen = intGreen;
	}

	/**
	 * @return the _intX
	 */
	public int getX() {
		return _intX;
	}

	/**
	 * @param intX the _intX to set
	 */
	public void setX(int intX) {
		this._intX = intX;
	}

	/**
	 * @return the _intY
	 */
	public int getY() {
		return _intY;
	}

	/**
	 * @param intY the _intY to set
	 */
	public void setY(int intY) {
		this._intY = intY;
	}

	/**
	 * @return the _intRelX
	 */
	public Integer getRelX() {
		return _intRelX;
	}

	/**
	 * @param _intRelX the _intRelX to set
	 */
	public void setRelX(Integer intRelX) {
		this._intRelX = intRelX;
	}

	/**
	 * @return the _intRelY
	 */
	public Integer getRelY() {
		return _intRelY;
	}

	/**
	 * @param _intRelY the _intRelY to set
	 */
	public void setRelY(Integer intRelY) {
		this._intRelY = intRelY;
	}

	/**
	 * @return the _objRelRGB
	 */
	public RGB getRelRGB() {
		return _objRelRGB;
	}

	/**
	 * @param _objRelRGB the _objRelRGB to set
	 */
	public void setRelRGB(RGB _objRelRGB) {
		this._objRelRGB = _objRelRGB;
	}
	
	
	
}
