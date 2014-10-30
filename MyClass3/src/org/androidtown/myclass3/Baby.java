package org.androidtown.myclass3;

import android.widget.Toast;

public class Baby extends Person {
	
	public Baby(String inName, MainActivity inActivity) {
		name = inName;
		activity = inActivity;
	}
	
	public void cry() {
		Toast.makeText(activity.getApplicationContext(), name + "ÀÌ(°¡) ¿ó´Ï´Ù.", Toast.LENGTH_LONG).show();
		activity.imageView1.setImageResource(R.drawable.baby_cry);
	}
	
}
