package org.androidtown.myclass4;

import android.widget.Toast;

public class Person {
	public static int total = 0;
	public int age = 0;
	
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
	
	public void cry() {
		Toast.makeText(activity.getApplicationContext(), "��� ����� �𸨴ϴ�.", Toast.LENGTH_LONG).show();
	}
}
