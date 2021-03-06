package org.androidtown.myclass3;

import android.widget.Toast;

public class Person {
	protected String name;
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
		Toast.makeText(activity.getApplicationContext(), name + "이(가) " + speed + "km 속도로 걸어갑니다.", Toast.LENGTH_LONG).show();
		activity.imageView1.setImageResource(R.drawable.person_walk);
	}
	
	public void run(int speed) {
		Toast.makeText(activity.getApplicationContext(), name + "이(가) " + speed + "km 속도로 뛰어갑니다.", Toast.LENGTH_LONG).show();
		activity.imageView1.setImageResource(R.drawable.person_run);
	}
	
}
