package edu.gatech.seclass.unitconvertor;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class DistanceActivity extends Activity {
	
	EditText mEditText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_distance);
		
		mEditText = (EditText) findViewById(R.id.text1);
	}
	
	public void handleClick(View view){
		
		if(mEditText.getText().length()==0){
			showError();
			return;
		}
		
		boolean checked = ((RadioButton) view).isChecked();
		
		EditText txt = (EditText) findViewById(R.id.text1);
		
		double distance = Double.parseDouble(txt.getText().toString());
		
		switch(view.getId()){
		case R.id.radio0:
			if(checked)
				txt.setText(kmToMiles(distance));
			break;
		case R.id.radio1:
			if(checked)
				txt.setText(milesToKm(distance));
			break;
			
		}
	}
	
	public String kmToMiles(double km){
		double miles = km / 1.6093;
		return String.format("%.3f", miles);
		//return String.valueOf(miles);
	}
	
	public String milesToKm(double miles){
		double km = miles * 1.6093;
		return String.format("%.3f", km);
		//return String.valueOf(km);
	}
	
	private void showError() {
		mEditText.setError("Input value may not be empty");
		}
	
}
