package edu.gatech.seclass.unitconvertor;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class AreaActivity extends Activity {
	
	EditText mEditText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_area);
		
		mEditText = (EditText) findViewById(R.id.text1);

	}
	
	public void handleClick(View view){
		boolean checked = ((RadioButton) view).isChecked();
		
		if(mEditText.getText().length()==0){
			showError();
			return;
		}
		
		EditText txt = (EditText) findViewById(R.id.text1);
		double area = Double.parseDouble(txt.getText().toString());
		
		switch(view.getId()){
		case R.id.radio0:
			if(checked)
				txt.setText(sqMetersToSqFeet(area));

			break;
		case R.id.radio1:
			if(checked)
				txt.setText(sqFeetToSqMeters(area));
			break;
			
		}
	}
	
	public String sqFeetToSqMeters(double sqFeet){
		double sqMeters = sqFeet / 10.7639;
		return String.format("%.3f", sqMeters);
		//return String.valueOf(sqMeters);
	}
	
	public String sqMetersToSqFeet(double sqMeters){
		double sqFeet = sqMeters * 10.7639;
		return String.format("%.3f", sqFeet);
		//return String.valueOf(sqFeet);
	}
	
	private void showError() {
		mEditText.setError("Input value may not be empty");
		}
}
