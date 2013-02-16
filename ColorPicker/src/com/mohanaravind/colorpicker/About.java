/**
 * 
 */
package com.mohanaravind.colorpicker;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * @author Aravind
 *
 */
public class About extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about);
	}

    public void btnOk_clicked(View view){
    	this.finish();    	
    }
	
	
}
