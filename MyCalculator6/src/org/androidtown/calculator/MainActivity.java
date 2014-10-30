package org.androidtown.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		/*
		Calculator calc = new Calculator(this);
		int result = calc.add(10, 10);
		*/
		
	}

	class Calculator {
		 
		public int add(int a, int b) {
			Toast.makeText(getApplicationContext(), "더하기를 했습니다.", Toast.LENGTH_LONG).show();
			return a + b;
		}
		
	}
	
}
