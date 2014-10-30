package org.androidtown.mydata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import android.app.Activity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	String[] names = {"ö��", "����", "����", "����", "����"};
	 
	int count = 0;
	
	ArrayList<Person> persons = new ArrayList<Person>();
	
	TextView textView1;
	
	LinearLayout linearLayout1;
	
	String[] groups = {"ģ��", "����"};
	
	HashMap<String, ArrayList<String>> phonebook = new HashMap<String, ArrayList<String>>();
	
	
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
		
		phonebook.put("ģ��", friends);
		 
		ArrayList<String> family = new ArrayList<String>();
		family.add("�ҸӴ�");
		family.add("�Ҿƹ���");
		family.add("����");
		family.add("�ƺ�");
		family.add("����");

		phonebook.put("����", family);
		
		String outNames = "";
		Set<String> keys = phonebook.keySet();
		Iterator<String> iter = keys.iterator();
		while(iter.hasNext()) {
			String curGroup = iter.next();
			outNames = outNames + ("\n" + curGroup + "�׷� : ");
			ArrayList<String> nameList = phonebook.get(curGroup);
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
				
				addPersonTextView(curName);
				
				/*
				TextView nameTextView = new TextView(getApplicationContext());
				nameTextView.setText(curName);
				nameTextView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 30);
				
				LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
						LinearLayout.LayoutParams.MATCH_PARENT,
						LinearLayout.LayoutParams.WRAP_CONTENT);
				
				linearLayout1.addView(nameTextView, params);
				*/
				
				
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

				addPersonTextView(curName);

				textView1.setText(persons.size() + " ��");

				
				/*
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
				*/
				
			}
			
		});
		
		
		Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
        
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, groups);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);   
		
		spinner1.setAdapter(adapter); 
		
		spinner1.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				Toast.makeText(getApplicationContext(), "���õ� ������ �ε��� : " + arg2, Toast.LENGTH_LONG).show();
			
				String curGroup = groups[arg2];
				ArrayList<String> nameList = phonebook.get(curGroup);
				linearLayout1.removeAllViews();
				for (int i = 0; i < nameList.size(); i++) {
					String curName = nameList.get(i);
					
					addPersonTextView(curName);

					textView1.setText(persons.size() + " ��");
				}
				
				/*
				Toast.makeText(getApplicationContext(), "���õ� ������ �ε��� : " + arg2, Toast.LENGTH_LONG).show();
				
				String curGroup = groups[arg2];
				ArrayList<String> nameList = phonebook.get(curGroup);
				for (int i = 0; i < nameList.size(); i++) {
					String curName = nameList.get(i);

					TextView nameTextView = new TextView(getApplicationContext());
					nameTextView.setText(curName);
					nameTextView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 30);
					
					LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
							LinearLayout.LayoutParams.MATCH_PARENT,
							LinearLayout.LayoutParams.WRAP_CONTENT);
					
					linearLayout1.addView(nameTextView, params);

					textView1.setText(persons.size() + " ��");
				}
				*/
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				
			}
			
		});
		
	}

	
	public void addPersonTextView(String curName) {
		TextView nameTextView = new TextView(getApplicationContext());
		nameTextView.setText(curName);
		nameTextView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 30);
		
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.MATCH_PARENT,
				LinearLayout.LayoutParams.WRAP_CONTENT);
		
		linearLayout1.addView(nameTextView, params);
	}
	
	
}
