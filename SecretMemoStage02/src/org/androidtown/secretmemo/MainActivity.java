package org.androidtown.secretmemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	private static final String TAG = "MainActivity";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // �� �޸� ��ư ����
        Button button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(), MemoInputActivity.class);
				intent.putExtra("mode", "create");
				startActivityForResult(intent, 1001);
			}
		});
        
        // ��й�ȣ ���� ��ư ����
        Button button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(), PasswordSettingActivity.class);
				startActivityForResult(intent, 1002);
			}
		});

        // ������ ��ư ����
        Button button3 = (Button)findViewById(R.id.button3);
        button3.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				finish();
			}
		});
        
    }


    @Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		
		Log.d(TAG, "onActivityResult() ȣ��� : " + requestCode + ", " + resultCode);
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
		}
		
	}

}
