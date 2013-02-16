/**
 * 
 */
package com.mohanaravind.utility;

import android.app.Application;
import android.net.Uri;

/**
 * @author Aravind
 *
 */
public class GlobalApplicationState extends Application {

	
    //sensible place to declare a log tag for the application
    public static final String LOG_TAG = "myapp";

    //instance 
    private static GlobalApplicationState instance = null;

    //keep references to our global resources
	private static Uri _fileURI = null;

	/**
	 * @return the _fileURI
	 */
	public Uri getURI() {
		if (_fileURI == null) {
            checkInstance();
            
		}
		
		return _fileURI;
	}

	/**
	 * @param fileURI the _fileURI to set
	 */
	public void setURI(Uri fileURI) {
		GlobalApplicationState._fileURI = fileURI;
	}
	
	/**
	 * Clears the URI
	 */
	public void clearURI(){
		GlobalApplicationState._fileURI = null;
	}
			

    /**
     * Convenient accessor, saves having to call and cast getApplicationContext() 
     */
    public static GlobalApplicationState getInstance() {
        checkInstance();
        return instance;
    }

    private static void checkInstance() {
        if (instance == null)
            throw new IllegalStateException("Application not created yet!. Check the manifest");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //provide an instance for our static accessors
        instance = this;
    }
	
	
}
