package org.androidtown.secretmemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private static final String TAG = "MainActivity";
	
	ListView listView1;
	MemoAdapter adapter;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // 새 메모 버튼 설정
        Button button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(), MemoInputActivity.class);
				intent.putExtra("mode", "create");
				startActivityForResult(intent, 1001);
			}
		});
        
        // 비밀번호 설정 버튼 설정
        Button button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(), PasswordSettingActivity.class);
				startActivityForResult(intent, 1002);
			}
		});

        // 끝내기 버튼 설정
        Button button3 = (Button)findViewById(R.id.button3);
        button3.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				finish();
			}
		});
        
        // 메모 리스트
        listView1 = (ListView)findViewById(R.id.listView1);
    	adapter = new MemoAdapter(this);
    	listView1.setAdapter(adapter);
    	listView1.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
				Toast.makeText(getApplicationContext(), "Item #" + position + " 클릭됨.", Toast.LENGTH_LONG).show();
			}
		});
        
    }


    @Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		
		Log.d(TAG, "onActivityResult() 호출됨 : " + requestCode + ", " + resultCode);
		if (requestCode == 1001) {
			String mode = data.getStringExtra("mode");
			String contents = data.getStringExtra("contents");
			String friendName = data.getStringExtra("friendName");
			String friendMobile = data.getStringExtra("friendMobile");
			String timestamp = data.getStringExtra("timestamp");
			
			Toast.makeText(getApplicationContext(), "mode : " + mode
													+ "contents : " + contents
													+ "friendName : " + friendName
													+ "friendMobile : " + friendMobile
													+ "timestamp : " + timestamp, Toast.LENGTH_LONG).show();
		
			if (mode != null && mode.equals("create")) {
				MemoItem item = new MemoItem(contents, friendName, friendMobile, timestamp, "");
				adapter.addItem(item);
				adapter.notifyDataSetChanged();
			}
		}
		
	}

}
