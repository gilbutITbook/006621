package org.androidtown.myclass;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	EditText editText1;
	ImageView imageView1;
	
	Person person01;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		editText1 = (EditText) findViewById(R.id.editText1);
		imageView1 = (ImageView) findViewById(R.id.imageView1);
		 
	}

	public void onButton1Clicked(View v) {
		//Person person01 = new Person("Ã¶¼ö", this);
		
		//createPerson("Ã¶¼ö");
		
		String name = editText1.getText().toString();
		createPerson(name);
		
		
	}
	
	public void onButton2Clicked(View v) {
		person01.walk(10);
	}

	public void onButton3Clicked(View v) {
		person01.run(10);
	}
	
	public void createPerson(String name) {
		person01 = new Person(name, this);
	}
	 
}


class Person {
	String name;
	Leg leg = new Leg();
	MainActivity activity;
	
	public Leg getLeg() {
		return leg;
	}
	
	
	public Person() {
		
	}
	
	public Person(String inName, MainActivity inActivity) {
		name = inName;
		activity = inActivity;
	}
	
	public void walk(int speed) {
		Toast.makeText(activity.getApplicationContext(), name + "ÀÌ(°¡) " + speed + "km ¼Óµµ·Î °É¾î°©´Ï´Ù.", Toast.LENGTH_LONG).show();
		activity.imageView1.setImageResource(R.drawable.person_walk);
	}
	
	public void run(int speed) {
		Toast.makeText(activity.getApplicationContext(), name + "ÀÌ(°¡) " + speed + "km ¼Óµµ·Î ¶Ù¾î°©´Ï´Ù.", Toast.LENGTH_LONG).show();
		activity.imageView1.setImageResource(R.drawable.person_run);
	}
	
}

class Leg {
	String left = "¿ÞÂÊ";
	String right = "¿À¸¥ÂÊ";
	
	public String getLeft() {
		return left;
	}
	
	public void setLeft(String left) {
		this.left = left;
	}
	
	public String getRight() {
		return right;
	}
	
	public void setRight(String right) {
		this.right = right;
	}

}

