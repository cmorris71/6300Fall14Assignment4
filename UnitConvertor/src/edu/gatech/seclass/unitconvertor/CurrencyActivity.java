package edu.gatech.seclass.unitconvertor;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class CurrencyActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_currency);
	}
	
	public void handleClick(View view){
		boolean checked = ((RadioButton) view).isChecked();
		
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
}
