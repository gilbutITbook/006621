package org.androidtown.mydata;

import java.util.ArrayList;
import java.util.Iterator;

import android.app.Activity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	LinearLayout linearLayout1;
		
	String[] names = {"ö��", "����", "����", "����", "����"};
	 
	int count = 0;

	ArrayList<Person> persons = new ArrayList<Person>();
	
	TextView textView1;

	ArrayList<ArrayList<String>> phonebook = new ArrayList<ArrayList<String>>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	 

		ArrayList<String> friends = new ArrayList<String>();
		friends.add("ö��");
		friends.add("����");
		friends.add("����");
		friends.add("����");
		friends.add("����");
		
		phonebook.add(friends);
		 
		ArrayList<String> family = new ArrayList<String>();
		family.add("�ҸӴ�");
		family.add("�Ҿƹ���");
		family.add("����");
		family.add("�ƺ�");
		family.add("����");

		phonebook.add(family);
		
		String outNames = "";
		for (int i = 0; i < phonebook.size(); i++) {
			outNames = outNames + ("\n" + i + " �ε����� �׷� : ");
			ArrayList<String> nameList = phonebook.get(i);
			for (int j = 0; j < nameList.size(); j++) {
				outNames = outNames + nameList.get(j);
				if (j < (nameList.size()-1)) {
					outNames = outNames + ",";
				}
			}
		}
		
		System.out.println(outNames);
		
		linearLayout1 = (LinearLayout) findViewById(R.id.linearLayout1);
		textView1 = (TextView) findViewById(R.id.textView1);
		
	    Button button1 = (Button) findViewById(R.id.button1);
	    button1.setOnClickListener(new OnClickListener() {

	    	@Override
	    	public void onClick(View arg0) {
	    		int nameIndex = count % 5;
				Person curPerson = new Person(names[nameIndex]);
				persons.add(curPerson);
				Toast.makeText(getApplicationContext(), "��� " + names[nameIndex] + "�� ����������ϴ�.", Toast.LENGTH_LONG).show();
 
				String curName = curPerson.getName();
				TextView nameTextView = new TextView(getApplicationContext());
				nameTextView.setText(curName);
				nameTextView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 30);
				
				LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
						LinearLayout.LayoutParams.MATCH_PARENT,
						LinearLayout.LayoutParams.WRAP_CONTENT);
				
				linearLayout1.addView(nameTextView, params);
				
				
				count++;
				
				textView1.setText(count + " ��");
				
				
				for (int i = 0; i < persons.size(); i++) {
					System.out.println(i + " : " + persons.get(i).getName());
				}
				
				Iterator<Person> iter = persons.iterator();
				int outIndex = 0;
				while(iter.hasNext()) {
					Person outPerson = iter.next();
					System.out.println(outIndex + " : " + outPerson.getName());
					outIndex++;
				}
				 
	    	}
		
	    });

		Button button2 = (Button) findViewById(R.id.button2);
		button2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				EditText editText1 = (EditText) findViewById(R.id.editText1);
				String curName = editText1.getText().toString();
				
				Person curPerson = new Person(curName);
				persons.add(curPerson);
				Toast.makeText(getApplicationContext(), "��� " + curName + "�� ����������ϴ�.", Toast.LENGTH_LONG).show();

				TextView nameTextView = new TextView(getApplicationContext());
				nameTextView.setText(curName);
				nameTextView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 30);
				
				LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
						LinearLayout.LayoutParams.MATCH_PARENT,
						LinearLayout.LayoutParams.WRAP_CONTENT);
				
				linearLayout1.addView(nameTextView, params);

				textView1.setText(persons.size() + " ��");
				
			}
			
		});
		
	}
}
