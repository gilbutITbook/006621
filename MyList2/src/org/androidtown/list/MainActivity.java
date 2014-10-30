package org.androidtown.list;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ListView listView1 = (ListView) findViewById(R.id.listView1);
		
		String[] names = {"소녀시대", "티아라", "걸스데이", "아이유", "애프터스쿨"};
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);
		listView1.setAdapter(adapter);
		
	}

}
