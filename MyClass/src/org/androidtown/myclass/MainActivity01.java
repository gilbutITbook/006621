package org.androidtown.myclass;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity01 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
 
		Person jack = new Person();
		jack.walk(10);
		
		Person mike = new Person();
		mike.walk(10);
		
		Person sean = new Person();
		jack.walk(10);
	    
	}

	class Person {

		public void walk(int speed) {
			System.out.println("����� " + speed + "km �ӵ��� �ɾ�ϴ�.");
		}
		
		public void run(int speed) {
			System.out.println("����� " + speed + "km �ӵ��� �پ�ϴ�.");
		}
		
	}
	 
}
