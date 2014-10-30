package org.androidtown.secretmemo;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MemoItemView extends LinearLayout {
	Context mContext;
	
	TextView textView1;
	TextView textView2;
	TextView textView3;
	TextView textView4;
	
	ImageView imageView1;
	
	public MemoItemView(Context context) {
		super(context);
		
		mContext = context;
		init();
	}
	
	public MemoItemView(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		mContext = context;
		init();
	}

	private void init() {
		LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.memo_item, this, true);
		
		textView1 = (TextView) findViewById(R.id.textView1);
		textView2 = (TextView) findViewById(R.id.textView2);
		textView3 = (TextView) findViewById(R.id.textView3);
		textView4 = (TextView) findViewById(R.id.textView4);
		
		imageView1 = (ImageView) findViewById(R.id.imageView1);
	}
	
	public void setContents(String contents) {
		textView1.setText(contents);
	}
	
	public void setFriendName(String friendName) {
		textView2.setText(friendName);
	}
	
	public void setFriendMobile(String friendMobile) {
		textView3.setText(friendMobile);
	}
	
	public void setTimestamp(String timestamp) {
		textView4.setText(timestamp);
	}
	
	public void setImage(Bitmap imageBitmap) {
		imageView1.setImageBitmap(imageBitmap);
	}
	
	public void setImageResource(int resId) {
		imageView1.setImageResource(resId);
	}
	
}
