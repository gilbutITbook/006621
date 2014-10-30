package org.androidtown.myclass;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity04 extends Activity {

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
		
		Person person04 = person03;
		person04.walk(10);
		
		String outName = person04.name;
		System.out.println("person04.name : " + outName);
		person03.name = "����";
		
		System.out.println("person04.name : " + outName);
		
		Leg outLeg = person04.leg;
		System.out.println("person04.leg : " + outLeg.left);
		person03.leg.left = "���� �ٸ�";
		
		System.out.println("person04.leg : " + outLeg.left);
		
		Leg outLeg2 = person04.getLeg();
		System.out.println("person04.leg : " + outLeg2.right);
		person03.leg.right = "������ �ٸ�";
		
		System.out.println("person04.leg : " + outLeg2.right);
		
	}

	class Person {
		String name;
		Leg leg = new Leg();
		
		public Leg getLeg() {
			return leg;
		}
		
		
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

	class Leg {
		String left = "����";
		String right = "������";
		
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
