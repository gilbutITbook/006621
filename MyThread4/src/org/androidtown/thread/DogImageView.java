package org.androidtown.thread;

import java.util.ArrayList;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;

public class DogImageView extends ImageView {
	Handler handler = new Handler();
	
	public DogImageView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	public DogImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		DogThread thread1 = new DogThread();
		thread1.start();
		
		return true;
	}

	class DogThread extends Thread {
		int stateIndex;
		
		ArrayList<Integer> images = new ArrayList<Integer>();

		public DogThread() {
			images.add(R.drawable.dog_standing);
			images.add(R.drawable.dog_running);
			images.add(R.drawable.dog_biting);
		}
		
		public void run() {
			stateIndex = 0;
			for (int i = 0; i < 9; i++) {
				handler.post(new Runnable() {
					public void run() {
						setImageResource(images.get(stateIndex));
					}
				});
				
				try {
					Thread.sleep(1000);
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
		
	}
	
}
