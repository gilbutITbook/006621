package org.androidtown.secretmemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PasswordSettingActivity extends Activity {
	TextView textView1;
	EditText editText1;
	EditText editText2;
	CheckBox checkBox1;
	Button button1;
	Button button2;
	
	String mode;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.password_setting);
        
        textView1 = (TextView) findViewById(R.id.textView1);
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
        
        // ���� ��ư ����
        button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// �� �� �Է»����� �� ��
				String password1 = editText1.getText().toString().trim();
				String password2 = editText2.getText().toString().trim();
				
				if (!password1.equals(password2)) {
					Toast.makeText(getApplicationContext(), "�Է��� �� ���� ��й�ȣ�� �ٸ��ϴ�.", Toast.LENGTH_LONG).show();
					return;
				}
				
				if (mode != null && mode.equals("lock")) {
					savePasswordUseYn(getApplicationContext(), "Y");
					savePassword(getApplicationContext(), password1);
					
					Toast.makeText(getApplicationContext(), "��й�ȣ�� �����Ǿ����ϴ�.", Toast.LENGTH_LONG).show();
					finish();
				} else if (mode.equals("unlock")) {
					String previousPassword = loadPassword(getApplicationContext());
					if (password1.equals(previousPassword)) {
						if (checkBox1.isChecked()) {
						  savePasswordUseYn(getApplicationContext(), "N");
						  savePassword(getApplicationContext(), "");
						
						  Toast.makeText(getApplicationContext(), "��й�ȣ�� �����Ǿ����ϴ�.", Toast.LENGTH_LONG).show();
						  finish();
						} else {
						  Toast.makeText(getApplicationContext(), "��й�ȣ�� Ȯ�εǾ����ϴ�.", Toast.LENGTH_LONG).show();
						  finish();
						}
					} else {
						Toast.makeText(getApplicationContext(), "��й�ȣ�� ���� �ʽ��ϴ�.", Toast.LENGTH_LONG).show();
					}
				} else {
					Toast.makeText(getApplicationContext(), "�˼����� mode �� : " + mode, Toast.LENGTH_LONG).show();
				}
				
			}
		});

        // ��� ��ư ����
        button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if (mode != null && mode.equals("unlock")) {
					Intent intent = new Intent();
					intent.putExtra("mode", "exit");
					setResult(Activity.RESULT_CANCELED);
					
					finish();
				} else {
					finish();
				}
			}
		});

        Intent intent = getIntent();
        mode = intent.getStringExtra("mode");
        if (mode != null && mode.equals("unlock")) {
        	checkBox1.setVisibility(View.VISIBLE);
        	
        	textView1.setText("��й�ȣ Ȯ��");
        	button1.setText("Ȯ��");
        	button2.setText("������");
        } else {
        	checkBox1.setVisibility(View.GONE);
        	
        	textView1.setText("��й�ȣ ����");
        	button1.setText("����");
        	button2.setText("���");
        }
        
    }
    

	/**
	 * ȯ�� ������ ��й�ȣ �����ϱ�
	 */
	public void savePassword(Context context, String password) {
		SharedPreferences preferences = context.getSharedPreferences("environ", 0);
		SharedPreferences.Editor editor = preferences.edit();
		editor.putString("password", password);
		editor.commit();
	}

	/**
	 * ȯ�� �������� ��й�ȣ ��������
     */
	public String loadPassword(Context context){
		SharedPreferences preferences = context.getSharedPreferences("environ", 0);
		
        return preferences.getString("password", "");
	}	
	
	/**
	 * ȯ�� ������ ��й�ȣ ��� ���� �����ϱ�
	 */
	public void savePasswordUseYn(Context context, String useYn){
		SharedPreferences preferences = context.getSharedPreferences("environ", 0);
		SharedPreferences.Editor editor = preferences.edit();
		editor.putString("passwordUseYn", useYn);
		editor.commit();
	}

}
