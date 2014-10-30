package org.androidtown.thread;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends Activity {

	ImageView imageView1;
	ImageView imageView2;
	
	EditText editText1;
	
	Handler handler = new Handler();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		imageView1 = (ImageView) findViewById(R.id.imageView1);
		imageView2 = (ImageView) findViewById(R.id.imageView2);
		
		editText1 = (EditText) findViewById(R.id.editText1);
		
		Button button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				DogThread thread1 = new DogThread(0);
				thread1.start();
				
				DogThread thread2 = new DogThread(1);
				thread2.start();
			}
			
		});
		
		
	}

	
	class DogThread extends Thread {
		int dogIndex;
		int stateIndex;
		
		ArrayList<Integer> images = new ArrayList<Integer>();
		
		public DogThread(int index) {
			dogIndex = index;
			
			images.add(R.drawable.dog_standing);
			images.add(R.drawable.dog_running);
			images.add(R.drawable.dog_biting);
		}
		
		public void run() {
			stateIndex = 0;
			for (int i = 0; i < 9; i++) {
				final String msg = "dog #" + dogIndex + " state : " + stateIndex;
				
				handler.post(new Runnable() {
					public void run() {
						editText1.append(msg + "\n");
						
						if (dogIndex == 0) {
							imageView1.setImageResource(images.get(stateIndex));
						} else if (dogIndex == 1) {
							imageView2.setImageResource(images.get(stateIndex));
						}
					}
				});
				
				try {
					int sleepTime = getRandomTime(500, 3000);
					Thread.sleep(sleepTime);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				stateIndex++;
				if (stateIndex >= images.size()) {
					stateIndex = 0;
				}
			}
		}
		
		public int getRandomTime(int min, int max) {
		    return min + (int)(Math.random() * (max - min));
		}
	}
	
}
