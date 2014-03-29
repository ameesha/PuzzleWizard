package com.example.puzzlewizard;

import com.example.puzzlewizard.StateMachine.State;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.view.MotionEventCompat;
import android.view.Menu;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

public class Villager extends Activity{
	
	@SuppressLint("NewApi")
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_villager);
		createConvoStart();
	}
	
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_screen, menu);
		return true;
	}
	
	@SuppressLint("NewApi")
	public void createConvoStart(){
		TextView start = (TextView) findViewById(R.id.maintext);
		start.setText("Wizard, could you help me solve this question?");
		Button yes = (Button) findViewById(R.id.yes_button);
		yes.setText("Only if you pay me.");
		yes.setY(100);
		Button no = (Button) findViewById(R.id.no_button);
		no.setText("I'm too busy for this. Figure it out yourself.");
		no.setY(200);
	}
	
	public void endPuzzle(View view){
		MainActivity.state.setState(State.Field);
		Intent intent = new Intent(this, Screen.class);
    	startActivity(intent);
	}
	
	@SuppressLint("NewApi")
	public void beginPuzzle(View view){
		createQuestion();
		Button yes = (Button) findViewById(R.id.yes_button);
		yes.setVisibility(0);
		Button no = (Button) findViewById(R.id.no_button);
		no.setVisibility(1);
	}
	
	public void createQuestion(){
		TextView start = (TextView) findViewById(R.id.maintext);
		start.invalidate();
		start.setText("What can one not keep, two hold, and three destroy? (2 words)");
			
	}
	
}
