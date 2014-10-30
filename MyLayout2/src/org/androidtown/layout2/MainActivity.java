package org.androidtown.layout2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {
	ImageView imageView1;
	ImageView imageView2;
	ImageView imageView3;
	
	int index = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		imageView1 = (ImageView) findViewById(R.id.imageView1);
		imageView2 = (ImageView) findViewById(R.id.imageView2);
		imageView3 = (ImageView) findViewById(R.id.imageView3);
		
		Button button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				if (index == 0) {
					imageView1.setVisibility(View.VISIBLE);
					imageView2.setVisibility(View.GONE);
					imageView3.setVisibility(View.GONE);
				} else if (index == 1) {
					imageView1.setVisibility(View.GONE);
					imageView2.setVisibility(View.VISIBLE);
					imageView3.setVisibility(View.GONE);
				} else if (index == 2) {
					imageView1.setVisibility(View.GONE);
					imageView2.setVisibility(View.GONE);
					imageView3.setVisibility(View.VISIBLE);
				}
				
				index++;
				if (index > 2) {
					index = 0;
				}
			}
			
		});
		
	}

}
