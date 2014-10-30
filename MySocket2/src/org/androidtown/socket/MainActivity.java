package org.androidtown.socket;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	EditText editText1;
	EditText editText2;
	
	Button button1;
	
	Handler handler = new Handler();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		editText1 = (EditText) findViewById(R.id.editText1);
		editText2 = (EditText) findViewById(R.id.editText2);
		
		button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				ConnectThread thread = new ConnectThread();
				thread.start();
			}
			
		});
		
	}

	class ConnectThread extends Thread {
		public void run() {
			String inputStr = editText1.getText().toString();
			
			try {
				Socket aSocket = new Socket("172.30.21.19", 11001);
				
				ObjectOutputStream outstream = new ObjectOutputStream(aSocket.getOutputStream());
				outstream.writeObject(inputStr);
				outstream.flush();

				ObjectInputStream instream = new ObjectInputStream(aSocket.getInputStream());
				final Object obj = instream.readObject();

				handler.post(new Runnable() {
					public void run() {
						editText2.append(obj + "\n");
					}
				});
				
				aSocket.close();

			} catch(Exception ex) {
				ex.printStackTrace();
			}
			
		}
	}
	
}
