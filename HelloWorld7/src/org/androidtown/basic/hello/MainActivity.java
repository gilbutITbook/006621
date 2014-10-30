package org.androidtown.basic.hello;

import android.app.Activity;
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

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), "��ư�� ���Ⱦ��.", Toast.LENGTH_LONG).show();
			}
        	
        });
        
    }

    public void onButton1Clicked(View v) {
    	Toast.makeText(this, "��ư�� ���Ƚ��ϴ�.", Toast.LENGTH_LONG).show();
    }
    
}
