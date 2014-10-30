package org.androidtown.secretmemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MemoInputActivity extends Activity {

	// 메모
	EditText editText1;
	// 친구이름
	EditText editText2;
	// 친구번호
	EditText editText3;
	
	// 일시
	TextView textView1;
	
	// 메모 모드
	String mode;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memo_input);
        
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        textView1 = (TextView) findViewById(R.id.textView1);
        
        // 저장 버튼 설정
        Button button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				String contents = editText1.getText().toString();
				String friendName = editText2.getText().toString();
				String friendMobile = editText3.getText().toString();
				String timestamp = textView1.getText().toString();
				
				Intent intent = new Intent();
				intent.putExtra("mode", mode);
				intent.putExtra("contents", contents);
				intent.putExtra("friendName", friendName);
				intent.putExtra("friendMobile", friendMobile);
				intent.putExtra("timestamp", timestamp);

				setResult(Activity.RESULT_OK, intent);
				finish();
			}
		});
        
        // 취소 버튼 설정
        Button button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				finish();
			}
		});

        // 전달된 인텐트 데이터 처리
        Intent intent = getIntent();
        mode = intent.getStringExtra("mode");
        
    }

}
