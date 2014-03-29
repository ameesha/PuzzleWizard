package com.example.puzzlewizard;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.MotionEventCompat;
import android.view.Menu;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

public class Villager  extends Activity{
	
	User user = new User();
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
	
	public void createConvoStart(){
		TextView start = (TextView) findViewById(R.id.maintext);
		start.setText("Wizard, could you help me solve this question?");
		Button yes = (Button) findViewById(R.id.yes_button);
		yes.setText("Only if you pay me.");
		yes.setOnTouchListener((OnTouchListener) this);
		Button no = (Button) findViewById(R.id.no_button);
		no.setText("I'm too busy for this. Figure it out yourself.");
	}
	
	//this can be done in model, possibly
	//if yes is clicked, stay here
	//if no is clicked leave
	public boolean onTouchEvent(MotionEvent event)
	{
		int action = MotionEventCompat.getActionMasked(event);
		
		//fix up later
		switch(action)
		{
		case (MotionEvent.ACTION_DOWN) :
			Button c = new Button(this);
			c.setText("C");
			c.setVisibility(1);
			LinearLayout ll = (LinearLayout)findViewById(R.id.layout);
			LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
			ll.addView(c, lp);
			
			Button r = new Button(this);
			r.setText("R");
			r.setVisibility(1);
			ll.addView(r, lp);
			return true;
		default :
			return true;
		}
	}
	
	
	public void createQuestion(){
		TextView start = (TextView) findViewById(R.id.maintext);
		start.invalidate();
		start.setText("What can one not keep, two hold, and three destroy? (2 words)");
		Button yes = (Button) findViewById(R.id.yes_button);
		yes.setVisibility(0);
		Button no = (Button) findViewById(R.id.no_button);
		no.setVisibility(0);
		
	}
	
}
