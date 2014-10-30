package org.androidtown.secretmemo;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MemoInputActivity extends Activity {

	// �޸�
	EditText editText1;
	// ģ���̸�
	EditText editText2;
	// ģ����ȣ
	EditText editText3;

	// Ÿ��Ʋ
	TextView textView1;
	
	// �Ͻ�
	TextView textView2;
	
	// �̹�����
	ImageView imageView1;
	
	// �̹��� ��Ʈ��
	Bitmap imageBitmap;
	
	// �޸� ���
	String mode;
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy�� MM�� dd�� HH�� mm��");
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memo_input);
        
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);
        imageView1 = (ImageView) findViewById(R.id.imageView1);
        
        // ���� ��ư ����
        Button button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				String contents = editText1.getText().toString();
				String friendName = editText2.getText().toString();
				String friendMobile = editText3.getText().toString();
				String timestamp = textView2.getText().toString();
				
				Intent intent = new Intent();
				intent.putExtra("mode", mode);
				intent.putExtra("contents", contents);
				intent.putExtra("friendName", friendName);
				intent.putExtra("friendMobile", friendMobile);
				intent.putExtra("timestamp", timestamp);
				intent.putExtra("imageBitmap", imageBitmap);

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

        // �̹����� ��ġ �� �������
        imageView1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
			    startActivityForResult(intent, 1004);
			}
		});
        

        // ��ȭ ��ư ����
        Button button3 = (Button)findViewById(R.id.button3);
        button3.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				String friendMobile = editText3.getText().toString();
				
				Intent intent = new Intent(Intent.ACTION_CALL);
				intent.setData(Uri.parse("tel:" + friendMobile));
				startActivity(intent);
			}
		});
        
        // ���� ��ư ����
        Button button4 = (Button)findViewById(R.id.button4);
        button4.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				String friendMobile = editText3.getText().toString();
				
				Intent intent = new Intent(Intent.ACTION_VIEW);
				intent.putExtra("address", friendMobile);
				intent.setType("vnd.android-dir/mms-sms");
				startActivity(intent);
			}
		});

        
        // ���޵� ����Ʈ ������ ó��
        Intent intent = getIntent();
        mode = intent.getStringExtra("mode");
        
        if (mode != null && mode.equals("create")) {
        	textView1.setText("�� �޸�");
        	
        	Date date = new Date();
        	String timestamp = dateFormat.format(date);
        	
        	textView2.setText(timestamp);
        } else if (mode.equals("modify")) {
        	String contents = intent.getStringExtra("contents");
        	String friendName = intent.getStringExtra("friendName");
        	String friendMobile = intent.getStringExtra("friendMobile");
        	String timestamp = intent.getStringExtra("timestamp");
        	Bitmap imageBitmap = intent.getParcelableExtra("imageBitmap");
        	
        	textView1.setText("�޸� ����");
        	
        	editText1.setText(contents);
        	editText2.setText(friendName);
        	editText3.setText(friendMobile);
        	textView2.setText(timestamp);
        	imageView1.setImageBitmap(imageBitmap);
        }
        
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1004 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            imageBitmap = (Bitmap) extras.get("data");
            imageView1.setImageBitmap(imageBitmap);
        }
    }
    
}
