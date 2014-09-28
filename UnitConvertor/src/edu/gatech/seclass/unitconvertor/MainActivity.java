package edu.gatech.seclass.unitconvertor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	/** Called when the user clicks the Distance button */
	public void goDistance(View view) {
	    // Do something in response to button
		Intent intent = new Intent(this, DistanceActivity.class);
	    startActivity(intent);
	}
	
	/** Called when the user clicks the Distance button */
	public void goArea(View view) {
	    // Do something in response to button
		Intent intent = new Intent(this, AreaActivity.class);
	    startActivity(intent);
	}
	
	/** Called when the user clicks the Distance button */
	public void goCurrency(View view) {
	    // Do something in response to button
		Intent intent = new Intent(this, CurrencyActivity.class);
	    startActivity(intent);
	}
}
