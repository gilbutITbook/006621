package org.androidtown.add;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	EditText editText1;
	EditText editText2;
	TextView textView2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		editText1 = (EditText) findViewById(R.id.editText1);
		editText2 = (EditText) findViewById(R.id.editText2);
		textView2 = (TextView) findViewById(R.id.textView2);
		
	}

	public void onButton1Clicked(View v) {
	    String value01 = editText1.getText().toString();
	    String value02 = editText2.getText().toString();

	    int input01 = Integer.parseInt(value01);
	    int input02 = Integer.parseInt(value02);
		
	    int value03 = input01 + input02;
	    textView2.setText(String.valueOf(value03));

	    final int value04 = 100;
	    value03 = value03 + value04;
	    
	    textView2.setText(String.valueOf(value03));
	}
	
}
