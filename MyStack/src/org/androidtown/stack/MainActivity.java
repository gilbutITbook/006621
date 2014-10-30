package org.androidtown.stack;

import java.util.Stack;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	EditText editText1;
	Button button1;
	Button button2;

	Stack<Integer> stack = new Stack<Integer>();
	int count = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		editText1 = (EditText) findViewById(R.id.editText1);
		
		button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				stack.push(count);
				editText1.setText("스택에 추가함 : " + count);
				
				count++;
				
				editText1.append("\n스택 : " + stack);
			}
			
		});
		
		button2 = (Button) findViewById(R.id.button2);
		button2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				int outValue = stack.pop();
				editText1.setText("스택에서 가져옴 : " + outValue);
				
				editText1.append("\n스택 : " + stack);
			}
			
		});
		
	}

}
