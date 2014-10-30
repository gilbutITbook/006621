package org.androidtown.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	EditText editText1;
	EditText editText2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		editText1 = (EditText) findViewById(R.id.editText1);
		editText2 = (EditText) findViewById(R.id.editText2);
		
		Button button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				String filename = editText1.getText().toString();
				String contents = editText2.getText().toString();
				
				filename = "/sdcard/" + filename;
				
				writeToFile(filename, contents);
			}
			
		});
		
		Button button2 = (Button) findViewById(R.id.button2);
		button2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				String filename = editText1.getText().toString();
				 
				filename = "/sdcard/" + filename;
				
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
			FileOutputStream outstream = new FileOutputStream(file);
			OutputStreamWriter writer = new OutputStreamWriter(outstream);
			writer.write(contents);
			
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
			
			Toast.makeText(this, "파일에 쓰기 실패", Toast.LENGTH_LONG).show();
		}
	}
	
	
	public String readFromFile(String filename) {
		File file = new File(filename);
		
		String output = null;
		try {
			FileInputStream instream = new FileInputStream(file);
			BufferedReader reader = new BufferedReader(new InputStreamReader(instream));
			
			StringBuffer StrBuf = new StringBuffer();
			String aLine = "";
			while(aLine != null) {
				aLine = reader.readLine();
				
				if (aLine != null) {
					StrBuf.append(aLine + "\n");
				}
			}
			
			output = StrBuf.toString();
			
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
			
			Toast.makeText(this, "파일에서 읽기 실패", Toast.LENGTH_LONG).show();
		}
		
		return output;
	}
	
}
