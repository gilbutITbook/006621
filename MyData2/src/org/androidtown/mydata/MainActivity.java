package org.androidtown.mydata;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	String[] names = {"ö��", "����", "����", "����", "����"};
	//String[] names = new String[5];
	
	int count = 0;
		
	Person person01;
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		//names[0] = "ö��";
		//names[1] = "����";
		//names[2] = "����";
		//names[3] = "����";
		//names[4] = "����";
				
		
	    Button button1 = (Button) findViewById(R.id.button1);
	    button1.setOnClickListener(new OnClickListener() {

	    	@Override
	    	public void onClick(View arg0) {
	    		if (count < names.length) {
	    			person01 = new Person(names[count]);
	    			Toast.makeText(getApplicationContext(), 
	    		                        "��� " + names[count] + "�� ����������ϴ�.", 
	    		                        Toast.LENGTH_LONG).show();
	    		} else {
	    			Toast.makeText(getApplicationContext(), 
	    		                        "��� �̸��� �����ϴ�.", 
	    		                        Toast.LENGTH_LONG).show();
	    		}
	    			
	    		count++;
	    		    
	    		/*
	    		person01 = new Person(names[count]);
	    		Toast.makeText(getApplicationContext(), 
	    	                       "��� " + names[count] + "�� ����������ϴ�.", 
	    	                       Toast.LENGTH_LONG).show();
	    		
	    		count++;
	    		*/
	    	}
		
	    });

	}
}
