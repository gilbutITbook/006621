package org.androidtown.list;

import java.util.ArrayList;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class MyAdapter extends BaseAdapter {
	ArrayList<SingerItem> items = new ArrayList<SingerItem>();
	
	Context mContext;
	
	public MyAdapter(Context context) {
		mContext = context;
	}
	
	@Override
	public int getCount() {
		return items.size();
	}

	@Override
	public Object getItem(int position) {
		return items.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	public void addItem(SingerItem item) {
		items.add(item);
	}
	
	public void clear() {
		items.clear();
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		SingerLayout layout = new SingerLayout(mContext);
		
		SingerItem item = items.get(position);
		
		layout.setNameText(item.getName());
		layout.setAgeText(item.getAge());
		layout.setImage(item.getResId());
		
		
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
