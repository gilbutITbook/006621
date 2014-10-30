package org.androidtown.list;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ListView listView1 = (ListView) findViewById(R.id.listView1);
		
		MyAdapter adapter = new MyAdapter(this);
		listView1.setAdapter(adapter);
		
	}

}
