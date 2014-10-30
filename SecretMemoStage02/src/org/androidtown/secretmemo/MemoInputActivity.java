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

	// �޸�
	EditText editText1;
	// ģ���̸�
	EditText editText2;
	// ģ����ȣ
	EditText editText3;
	
	// �Ͻ�
	TextView textView1;
	
	// �޸� ���
	String mode;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memo_input);
        
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        textView1 = (TextView) findViewById(R.id.textView1);
        
        // ���� ��ư ����
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
        
        // ��� ��ư ����
        Button button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				finish();
			}
		});

        // ���޵� ����Ʈ ������ ó��
        Intent intent = getIntent();
        mode = intent.getStringExtra("mode");
        
    }

}
