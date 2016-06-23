package com.example.reg;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ResultActivity extends Activity {
	private TextView textViewUser;
	private EditText editTextUser, editTextPassWord, editTextSex, editTextBio;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.result);

		// init view
		textViewUser = (TextView) findViewById(R.id.textViewUser);
		editTextUser = (EditText) findViewById(R.id.editTextUser);
		editTextPassWord = (EditText) findViewById(R.id.editTextPassWord);
		editTextSex = (EditText) findViewById(R.id.editTextSex);
		editTextBio = (EditText) findViewById(R.id.editTextBio);

		// get info from bundle
		Bundle bundle = getIntent().getExtras();
		String user = bundle.getString("user");
		String password = bundle.getString("password");
		String sex = bundle.getString("sex");
		String bio = bundle.getString("bio");

		// set view
		textViewUser.setText(user);
		editTextUser.setText(user);
		editTextPassWord.setText(password);
		editTextSex.setText(sex);
		editTextBio.setText(bio);
	}

}
