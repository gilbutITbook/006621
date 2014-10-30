package org.androidtown.list;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends Activity {

	public String[] names = {"소녀시대", "티아라", "걸스데이", "아이유", "애프터스쿨"};
	public String[] ages = {"26", "23", "24", "27", "30"};
	public int[] images = {R.drawable.face01, R.drawable.face02, R.drawable.face03, R.drawable.face04, R.drawable.face05};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ListView listView1 = (ListView) findViewById(R.id.listView1);
		
		MyAdapter adapter = new MyAdapter(this);
		
		for (int i = 0; i < 5; i++) {
			SingerItem item = new SingerItem(names[i], ages[i], images[i]);
			adapter.addItem(item);
		}
		
		listView1.setAdapter(adapter);
		

	}

}
