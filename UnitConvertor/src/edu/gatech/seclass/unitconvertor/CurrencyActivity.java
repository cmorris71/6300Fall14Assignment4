package edu.gatech.seclass.unitconvertor;

import java.text.DecimalFormatSymbols;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class CurrencyActivity extends Activity {
	
	EditText mEditTextValue;
	EditText mEditTextER;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_currency);
		
		mEditTextValue = (EditText) findViewById(R.id.text1);
		mEditTextER = (EditText) findViewById(R.id.textExchangeRate);
	}
	
	public void handleClick(View view){
		boolean checked = ((RadioButton) view).isChecked();
		
		if(mEditTextValue.getText().length()==0){
			showError(mEditTextValue, "Input value may not be empty");
			return;
		}

		if(mEditTextER.getText().length()==0){
			showError(mEditTextER, "Exchange rate may not be empty");
			return;
		}		
		if(Double.parseDouble(mEditTextER.getText().toString())<=0){
			showError(mEditTextER, "Exchange rate must be greater than 0");
			return;
		}
		

		
		EditText txt = (EditText) findViewById(R.id.text1);
		double amount = Double.parseDouble(txt.getText().toString());
		
		EditText txtER = (EditText) findViewById(R.id.textExchangeRate);
		double exR = Double.parseDouble(txtER.getText().toString());
		
		switch(view.getId()){
		case R.id.radio0:
			if(checked)
				txt.setText(euroToDollar(amount, exR));

			break;
		case R.id.radio1:
			if(checked)
				txt.setText(dollarToEuro(amount, exR));
			break;
			
		}
	}
	
	public String dollarToEuro(double dollars, double exR){

		double euros = dollars / exR;
		return String.format("%.2f", euros);
	}
	
	public String euroToDollar(double euros, double exR){
		double dollars = euros * exR;
		return String.format("%.2f", dollars);
	}
	
	private void showError(EditText mField, String mMessage) {
		mField.setError(mMessage);
		}
}
