package org.androidtown.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	EditText editText1;
	EditText editText2;
	EditText editText3;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		editText1 = (EditText) findViewById(R.id.editText1);
		editText2 = (EditText) findViewById(R.id.editText2);
		editText3 = (EditText) findViewById(R.id.editText3);
		
		Button button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String aStr = editText1.getText().toString();
				String bStr = editText2.getText().toString();
				
				int a = 0;
				int b = 0;
				try {
					a = Integer.parseInt(aStr);
					b = Integer.parseInt(bStr);
				} catch(Exception ex) {
					ex.printStackTrace();
				}
				
				Calculator calculator = new MyCalculator();
				int result = calculator.add(a, b);
				
				calculator = new FriendCalculator(getApplicationContext());
				result = calculator.add(a, b);
				
				
				editText3.setText(String.valueOf(result));
			}
			
		});
		
		Button button2 = (Button) findViewById(R.id.button2);
		button2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String aStr = editText1.getText().toString();
				String bStr = editText2.getText().toString();
				
				int a = 0;
				int b = 0;
				try {
					a = Integer.parseInt(aStr);
					b = Integer.parseInt(bStr);
				} catch(Exception ex) {
					ex.printStackTrace();
				}
				
				Calculator calculator = new MyCalculator();
				int result = 0;
				try {
					result = calculator.subtract(a, b);
				} catch (UnImplementedException e) {
					Toast.makeText(getApplicationContext(), "빼기는 안됩니다.", Toast.LENGTH_LONG).show();
					
					e.printStackTrace();
				}
				
				editText3.setText(String.valueOf(result));
			}
			
		});
		
	}

}
