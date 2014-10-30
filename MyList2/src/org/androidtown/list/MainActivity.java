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
		
		String[] names = {"�ҳ�ô�", "Ƽ�ƶ�", "�ɽ�����", "������", "�����ͽ���"};
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);
		listView1.setAdapter(adapter);
		
	}

}
