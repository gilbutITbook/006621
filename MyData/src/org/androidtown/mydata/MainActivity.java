package org.androidtown.mydata;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	String name01 = "ö��";
	String name02 = "����";
	String name03 = "����";
	String name04 = "����";
	String name05 = "����";
		
	int count = 0;
		
	Person person01;
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
	    Button button1 = (Button) findViewById(R.id.button1);
	    button1.setOnClickListener(new OnClickListener() {

	    	@Override
	    	public void onClick(View arg0) {
	    		if (count == 0) {
					person01 = new Person(name01);
					Toast.makeText(getApplicationContext(), "��� " + name01 + "�� ����������ϴ�.", Toast.LENGTH_LONG).show();
				} else if (count == 1) {
					person01 = new Person(name02);
					Toast.makeText(getApplicationContext(), "��� " + name02 + "�� ����������ϴ�.", Toast.LENGTH_LONG).show();
				} else if (count == 2) {
					person01 = new Person(name03);
					Toast.makeText(getApplicationContext(), "��� " + name03 + "�� ����������ϴ�.", Toast.LENGTH_LONG).show();
				} else if (count == 3) {
					person01 = new Person(name04);
					Toast.makeText(getApplicationContext(), "��� " + name04 + "�� ����������ϴ�.", Toast.LENGTH_LONG).show();
				} else if (count == 4) {
					person01 = new Person(name05);
					Toast.makeText(getApplicationContext(), "��� " + name05 + "�� ����������ϴ�.", Toast.LENGTH_LONG).show();
				}
				
				count++;
	    	}
		
	    });

	}
}
