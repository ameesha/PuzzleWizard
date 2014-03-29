package com.example.puzzlewizard;

import com.example.puzzlewizard.StateMachine.State;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class Instructions extends Activity {
	
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_instructions);
	}
	
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_instructions, menu);
		return true;
	}
	
	public void beginGame(View view){
		MainActivity.state.setState(State.Field);
		Intent intent = new Intent(this, Screen.class);
		startActivity(intent);
	}

}
