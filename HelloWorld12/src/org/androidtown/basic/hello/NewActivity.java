package org.androidtown.basic.hello;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class NewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newactivity);
        
        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Toast.makeText(getApplicationContext(), "돌아가기 버튼이 눌렸어요.", Toast.LENGTH_LONG).show();
				
				Intent intent = new Intent();
				intent.putExtra("name", "mike");

				setResult(User.RES_CODE_SUCCESS, intent);
				
				
				finish();
			}
        	
        });
        
        
        String loginName = User.loginName;
        Toast.makeText(getApplicationContext(), "새로운 화면에서 받은 loginName : " + loginName, Toast.LENGTH_LONG).show();
        
        
        /*
        Intent passedIntent = getIntent();
        String loginName = passedIntent.getStringExtra("loginName");
        Toast.makeText(getApplicationContext(), "새로운 화면에서 받은 loginName : " + loginName, Toast.LENGTH_LONG).show();
        */
        
    }


}
