package org.androidtown.mydata;

import android.app.Activity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	LinearLayout linearLayout1;
		
	String[] names = {"Ã¶¼ö", "¿µÈñ", "¹ÎÈñ", "¼öÁö", "Áö¹Î"};
	 
	int count = 0;
		
	Person[] persons = new Person[5];
	 
	TextView textView1;

	String[][] phonebook = new String[2][5];
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	 

		String[] friends = {"Ã¶¼ö", "¿µÈñ", "¹ÎÈñ", "¼öÁö", "Áö¹Î"};
		phonebook[0] = friends;
		
		String[] family = {"ÇÒ¸Ó´Ï", "ÇÒ¾Æ¹öÁö", "¾ö¸¶", "¾Æºü", "µ¿»ý"};
		phonebook[1] = family;
		
		String outNames = "";
		for (int i = 0; i < phonebook.length; i++) {
			outNames = outNames + ("\n" + i + " ÀÎµ¦½ºÀÇ ±×·ì : ");
			for (int j = 0; j < phonebook[i].length; j++) {
				outNames = outNames + phonebook[i][j];
				if (j < (phonebook[i].length-1)) {
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
	    		if (count >= persons.length) {
					Person[] tempPersons = new Person[persons.length + 5];
					System.arraycopy(persons, 0, tempPersons, 0, persons.length);
					persons = tempPersons;
				}
				
				int nameIndex = count % 5;
				persons[count] = new Person(names[nameIndex]);
				Toast.makeText(getApplicationContext(), "»ç¶÷ " + names[nameIndex] + "ÀÌ ¸¸µé¾îÁ³½À´Ï´Ù.", Toast.LENGTH_LONG).show();

				String curName = persons[count].getName();
				TextView nameTextView = new TextView(getApplicationContext());
				nameTextView.setText(curName);
				nameTextView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 30);
				
				LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
						LinearLayout.LayoutParams.MATCH_PARENT,
						LinearLayout.LayoutParams.WRAP_CONTENT);
				
				linearLayout1.addView(nameTextView, params);
				
				
				count++;
				
				textView1.setText(count + " ¸í");
				
	    	}
		
	    });

	}
}
