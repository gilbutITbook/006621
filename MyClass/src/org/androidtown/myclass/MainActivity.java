package org.androidtown.myclass;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
 
		Person person01 = new Person("Ã¶¼ö", this);
		person01.walk(10);
		
		Person person02 = new Person("¿µÈñ", this);
		person02.walk(10);
		
		Person person03 = new Person("¹ÎÈñ", this);
		person03.walk(10);
		
		Person person04 = person03;
		person04.walk(10);
		
		String outName = person04.name;
		System.out.println("person04.name : " + outName);
		person03.name = "¹ÎÁ¤";
		
		System.out.println("person04.name : " + outName);
		
		Leg outLeg = person04.leg;
		System.out.println("person04.leg : " + outLeg.left);
		person03.leg.left = "¿ÞÂÊ ´Ù¸®";
		
		System.out.println("person04.leg : " + outLeg.left);
		
		Leg outLeg2 = person04.getLeg();
		System.out.println("person04.leg : " + outLeg2.right);
		person03.leg.right = "¿À¸¥ÂÊ ´Ù¸®";
		
		System.out.println("person04.leg : " + outLeg2.right);
		
	    
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
		}
		
		public void run(int speed) {
			System.out.println(name + "ÀÌ(°¡) " + speed + "km ¼Óµµ·Î ¶Ù¾î°©´Ï´Ù.");
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
	 
}
