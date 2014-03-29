package com.example.puzzlewizard;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class GameOver extends Activity {
	@SuppressLint("NewApi")
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gameover);
	}
	
	public void restart(View view){
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
		finish();
	}

}
