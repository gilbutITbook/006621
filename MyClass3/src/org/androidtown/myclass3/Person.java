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
		Toast.makeText(activity.getApplicationContext(), name + "��(��) " + speed + "km �ӵ��� �ɾ�ϴ�.", Toast.LENGTH_LONG).show();
		activity.imageView1.setImageResource(R.drawable.person_walk);
	}
	
	public void run(int speed) {
		Toast.makeText(activity.getApplicationContext(), name + "��(��) " + speed + "km �ӵ��� �پ�ϴ�.", Toast.LENGTH_LONG).show();
		activity.imageView1.setImageResource(R.drawable.person_run);
	}
	
}
