package org.androidtown.thread;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends Activity {

	ImageView imageView1;
	
	EditText editText1;
	
	Handler handler = new Handler();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		imageView1 = (ImageView) findViewById(R.id.imageView1);
		
		editText1 = (EditText) findViewById(R.id.editText1);
		
		Button button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.translate);
				imageView1.startAnimation(anim);
			
				editText1.append("애니메이션 시작됨.\n");
			}
			
		});
		
		
	}

}
