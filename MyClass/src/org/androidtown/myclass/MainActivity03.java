package org.androidtown.myclass;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity03 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Person person01 = new Person();
		person01.name = "ö��";
		person01.walk(10);
		
		Person person02 = new Person();
		person02.name = "����";
		person02.walk(10);
		
		Person person03 = new Person();
		person03.name = "����";
		person03.walk(10);
	}

	class Person {
		String name;
		
		public Person() {
			
		}
		
		public Person(String inName) {
			name = inName;
		}
		
		public void walk(int speed) {
			System.out.println(name + "��(��) " + speed + "km �ӵ��� �ɾ�ϴ�.");
		}
		
		public void run(int speed) {
			System.out.println(name + "��(��) " + speed + "km �ӵ��� �پ�ϴ�.");
		}
		
	}
	 
}
