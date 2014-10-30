package org.androidtown.touch;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;

public class MainActivity extends Activity {
	EditText editText1;
	EditText editText2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		editText1 = (EditText) findViewById(R.id.editText1);
	    editText2 = (EditText) findViewById(R.id.editText2);
	    
		View view1 = (View) findViewById(R.id.view1);
		view1.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
			    float x = event.getX();
			    float y = event.getY();

			    editText1.setText(String.valueOf(x));
			    editText2.setText(String.valueOf(y));
			    
				return false;
			}
			
		});
		
	}
 
}
