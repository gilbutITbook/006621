package org.androidtown.mydata;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	String[] names = {"ö��", "����", "����", "����", "����"};
	//String[] names = new String[5];
	
	int count = 0;
		
	Person[] persons = new Person[5];
	//Person person01;

	TextView textView1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		//names[0] = "ö��";
		//names[1] = "����";
		//names[2] = "����";
		//names[3] = "����";
		//names[4] = "����";
				

		textView1 = (TextView) findViewById(R.id.textView1);
		
	    Button button1 = (Button) findViewById(R.id.button1);
	    button1.setOnClickListener(new OnClickListener() {

	    	@Override
	    	public void onClick(View arg0) {
	    		if (count >= persons.length) {
					Person[] tempPersons = new Person[persons.length + 5];
					System.arraycopy(persons, 0, tempPersons, 0, persons.length);
					persons = tempPersons;
				}
				
				int nameIndex = count % 5;
				persons[count] = new Person(names[nameIndex]);
				Toast.makeText(getApplicationContext(), "��� " + names[nameIndex] + "�� ����������ϴ�.", Toast.LENGTH_LONG).show();

				count++;
				
				textView1.setText(count + " ��");
				
				/*
	    		if (count < names.length) {
	    			persons[count] = new Person(names[count]);
	    			//person01 = new Person(names[count]);
	    			Toast.makeText(getApplicationContext(), 
	    		                        "��� " + names[count] + "�� ����������ϴ�.", 
	    		                        Toast.LENGTH_LONG).show();
	    		} else {
	    			Toast.makeText(getApplicationContext(), 
	    		                        "��� �̸��� �����ϴ�.", 
	    		                        Toast.LENGTH_LONG).show();
	    		}
	    			
	    		count++;
	    		
	    		for (int i = 0; i < names.length; i++) {
					System.out.println(i + " : " + names[i]);
				}
	    		*/
				
	    	}
		
	    });

	}
}
