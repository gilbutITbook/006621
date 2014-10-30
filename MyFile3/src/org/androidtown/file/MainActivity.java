package org.androidtown.file;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	EditText editText1;
	EditText editText2;
	
	String sdcardPath;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		editText1 = (EditText) findViewById(R.id.editText1);
		editText2 = (EditText) findViewById(R.id.editText2);
		
		File sdcardFolder = Environment.getExternalStorageDirectory();
		sdcardPath = sdcardFolder.getAbsolutePath();
		
		Button button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				String filename = editText1.getText().toString();
				String contents = editText2.getText().toString();
				
				filename = sdcardPath + File.separator + filename;
				
				writeToFile(filename, contents);
			}
			
		});
		
		Button button2 = (Button) findViewById(R.id.button2);
		button2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				String filename = editText1.getText().toString();
				 
				filename = sdcardPath + File.separator + filename;
				
				String contents = readFromFile(filename);
				if (contents != null) {
					editText2.setText(contents);
				} else {
					System.out.println("File contents is null.");
				}
			}
			
		});
	}

	public void writeToFile(String filename, String contents) {
		File file = new File(filename);
		try {
			FileOutputStream filestream = new FileOutputStream(file);
			DataOutputStream outstream = new DataOutputStream(filestream);
			outstream.writeUTF(contents);
			
			outstream.flush();
			outstream.close();
		} catch (Exception e) {
			e.printStackTrace();
			
			Toast.makeText(this, "파일에 쓰기 실패", Toast.LENGTH_LONG).show();
		}
	}
	
	
	public String readFromFile(String filename) {
		File file = new File(filename);
		
		String output = null;
		try {
			FileInputStream filestream = new FileInputStream(file);
			DataInputStream instream = new DataInputStream(filestream);
			
			StringBuffer StrBuf = new StringBuffer();
			int count = 0;
			byte[] data = new byte[1024];
			while(count > -1) {
				count = instream.read(data, 0, 1024);
				
				if (count > 0) {
					String aLine = new String(data, 0, count, "UTF8");
					if (aLine != null) {
						StrBuf.append(aLine);
					}
				}
			}
			
			output = StrBuf.toString();

			instream.close();
		} catch (Exception e) {
			e.printStackTrace();
			
			Toast.makeText(this, "파일에서 읽기 실패", Toast.LENGTH_LONG).show();
		}
		
		return output;
	}
	
}
