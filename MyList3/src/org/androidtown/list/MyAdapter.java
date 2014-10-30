package org.androidtown.list;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {

	public String[] names = {"소녀시대", "티아라", "걸스데이", "아이유", "애프터스쿨"};
	public String[] ages = {"26", "23", "24", "27", "30"};
	
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
		
		SingerLayout layout = new SingerLayout(mContext);
		layout.setNameText(names[position]);
		layout.setAgeText(ages[position]);
		
		
		/*
		LinearLayout layout = new LinearLayout(mContext);
		layout.setOrientation(LinearLayout.VERTICAL);
		
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.MATCH_PARENT,
				LinearLayout.LayoutParams.WRAP_CONTENT);
				
		TextView nameView = new TextView(mContext);
		nameView.setText(names[position]);
		nameView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 30);
		
		layout.addView(nameView, params);
		
		TextView ageView = new TextView(mContext);
		ageView.setText(ages[position]);
		ageView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 24);
		
		layout.addView(ageView, params);
		*/
		
		
		return layout;
	}

}
