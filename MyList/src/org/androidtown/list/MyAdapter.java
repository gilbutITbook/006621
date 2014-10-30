package org.androidtown.list;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {

	public String[] names = {"소녀시대", "티아라", "걸스데이", "아이유", "애프터스쿨"};
	
	Context mContext;
	
	public MyAdapter(Context context) {
		mContext = context;
	}
	
	@Override
	public int getCount() {
		return names.length;
	}

	@Override
	public Object getItem(int position) {
		return names[position];
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		TextView curView = new TextView(mContext);
		curView.setText(names[position]);
		curView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 30);
		
		return curView;
	}

}
