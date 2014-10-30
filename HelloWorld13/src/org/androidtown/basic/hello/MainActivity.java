package org.androidtown.basic.hello;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Toast.makeText(getApplicationContext(), "버튼이 눌렸어요.", Toast.LENGTH_LONG).show();

				User.loginName = "소녀시대";
				
				Intent myIntent = new Intent(getApplicationContext(), NewActivity.class);
				startActivityForResult(myIntent, User.REQ_CODE_PHONEBOOK);
				
				/*
				Intent myIntent = new Intent(getApplicationContext(), NewActivity.class);
			    myIntent.putExtra("loginName", "소녀시대");
				startActivityForResult(myIntent, 1);
				*/
			}
        	
        });
        
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				 Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"));
				 startActivity(intent);
			}
        	
        });
        
        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:01077881234"));
				startActivity(intent);
			}
        	
        });
        
        Toast.makeText(getApplicationContext(), "onCreate() 호출됨", Toast.LENGTH_LONG).show();
    }


    @Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		
		if (requestCode == User.REQ_CODE_PHONEBOOK) {
			if (resultCode == User.RES_CODE_SUCCESS) {
				String outName = data.getStringExtra("name");
				Toast.makeText(getApplicationContext(), "전달받은 name 속성의 값 : " + outName, Toast.LENGTH_LONG).show();
			} else {
				Toast.makeText(getApplicationContext(), "실패하였습니다.", Toast.LENGTH_LONG).show();
			}
		}
		
		/*
		 String outName = data.getStringExtra("name");
		 Toast.makeText(getApplicationContext(), "전달받은 name 속성의 값 : " + outName, Toast.LENGTH_LONG).show();
		 
		 */
		
	}


    @Override
	protected void onDestroy() {
		super.onDestroy();
		
		Toast.makeText(getApplicationContext(), "onDestroy() 호출됨", Toast.LENGTH_LONG).show();
	}


	@Override
	protected void onPause() {
		super.onPause();

		Toast.makeText(getApplicationContext(), "onPause() 호출됨", Toast.LENGTH_LONG).show();
	}


	@Override
	protected void onRestart() {
		super.onRestart();

		Toast.makeText(getApplicationContext(), "onRestart() 호출됨", Toast.LENGTH_LONG).show();
	}


	@Override
	protected void onResume() {
		super.onResume();

		Toast.makeText(getApplicationContext(), "onResume() 호출됨", Toast.LENGTH_LONG).show();
	}


	@Override
	protected void onStart() {
		super.onStart();

		Toast.makeText(getApplicationContext(), "onStart() 호출됨", Toast.LENGTH_LONG).show();
	}


	@Override
	protected void onStop() {
		super.onStop();

		Toast.makeText(getApplicationContext(), "onStop() 호출됨", Toast.LENGTH_LONG).show();
	}


}
