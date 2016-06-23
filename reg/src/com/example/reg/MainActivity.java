package com.example.reg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends Activity {
	private EditText editTextUser = null, editTextPassWord = null,
			editTextBio = null;
	private RadioGroup radioGroupSex = null;
	private Button buttonReg = null;
	private Bundle bundle = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// Init View
		editTextUser = (EditText) findViewById(R.id.editTextUser);
		editTextPassWord = (EditText) findViewById(R.id.editTextPassWord);
		editTextBio = (EditText) findViewById(R.id.editTextBio);
		radioGroupSex = (RadioGroup) findViewById(R.id.radioGroupSex);
		buttonReg = (Button) findViewById(R.id.buttonReg);
		// Init bundle
		bundle = new Bundle();

		// Set Event Listener
		buttonReg.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				// get info from view
				String strUser = editTextUser.getText().toString();
				String strPassWord = editTextPassWord.getText().toString();
				String strSex = "";
				int checkedRadioBtnId = radioGroupSex.getCheckedRadioButtonId();
				if (R.id.radioFemale == checkedRadioBtnId) {
					strSex = "Å®Éñ";
				} else {
					strSex = "ÄÐÉñ";
				}
				String strBio=editTextBio.getText().toString();
				
				Intent intent=new Intent(MainActivity.this,ResultActivity.class);
				
				bundle.putString("user", strUser);
				bundle.putString("password", strPassWord);
				bundle.putString("sex", strSex);
				bundle.putString("bio", strBio);
				
				intent.putExtras(bundle);
				
				startActivity(intent);
			}
		});

	}
}
