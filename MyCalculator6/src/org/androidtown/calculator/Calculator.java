package org.androidtown.calculator;

import android.content.Context;
import android.widget.Toast;

public class Calculator {
	Context mContext;
	
	public Calculator(Context context) {
		mContext = context;
	}
	
	public int add(int a, int b) {
		Toast.makeText(mContext, "���ϱ⸦ �߽��ϴ�.", Toast.LENGTH_LONG).show();
		return a + b;
	}
	
}
