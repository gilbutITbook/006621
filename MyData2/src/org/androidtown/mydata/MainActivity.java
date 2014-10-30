package org.androidtown.mydata;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	String[] names = {"철수", "영희", "민희", "수지", "지민"};
	//String[] names = new String[5];
	
	int count = 0;
		
	Person person01;
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		//names[0] = "철수";
		//names[1] = "영희";
		//names[2] = "민희";
		//names[3] = "수지";
		//names[4] = "지민";
				
		
	    Button button1 = (Button) findViewById(R.id.button1);
	    button1.setOnClickListener(new OnClickListener() {

	    	@Override
	    	public void onClick(View arg0) {
	    		if (count < names.length) {
	    			person01 = new Person(names[count]);
	    			Toast.makeText(getApplicationContext(), 
	    		                        "사람 " + names[count] + "이 만들어졌습니다.", 
	    		                        Toast.LENGTH_LONG).show();
	    		} else {
	    			Toast.makeText(getApplicationContext(), 
	    		                        "사람 이름이 없습니다.", 
	    		                        Toast.LENGTH_LONG).show();
	    		}
	    			
	    		count++;
	    		    
	    		/*
	    		person01 = new Person(names[count]);
	    		Toast.makeText(getApplicationContext(), 
	    	                       "사람 " + names[count] + "이 만들어졌습니다.", 
	    	                       Toast.LENGTH_LONG).show();
	    		
	    		count++;
	    		*/
	    	}
		
	    });

	}
}
