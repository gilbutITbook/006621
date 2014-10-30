package org.androidtown.myclass4;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends Activity {

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
		String name = editText1.getText().toString();
		
		RadioButton radio0 = (RadioButton) findViewById(R.id.radio0);
		boolean personChecked = radio0.isChecked();
		
		if (personChecked) {
			createPerson(name);
		} else {
			createBaby(name);
		}
		
		imageView1.setVisibility(View.VISIBLE);
	}
	
	public void onButton2Clicked(View v) {
		if (person01 != null) {
			person01.walk(10);
		}
	}

	public void onButton3Clicked(View v) {
		if (person01 != null) {
			person01.run(10);
		}
	}
	
	public void onButton4Clicked(View v) {
		if (person01 != null) {
			if (person01 instanceof Baby) {
				Baby baby01 = (Baby) person01;
				baby01.cry();
			} else {
				Toast.makeText(getApplicationContext(), "Baby 객체가 아니어서 cry 메소드를 호출할 수 없습니다.", Toast.LENGTH_LONG).show();
			}
		}
	}
	
	public void createPerson(String name) {
		person01 = new Person(name, this);
	}

	public void createBaby(String name) {
		person01 = new Baby(name, this);
		imageView1.setImageResource(R.drawable.baby);
	}
	 
}

