package com.example.puzzlewizard;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.support.v4.view.MotionEventCompat;
import android.view.MotionEvent;

public class Person extends Activity{

	private int XP = 10;
	private Model model = null;
	
	Person()
	{
		//do nothing for now
	}
	
	
	public void setModel(Model mod)
	{
		this.model = mod;
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event)
	{
		int action = MotionEventCompat.getActionMasked(event);
		
		//fix up later
		switch(action)
		{
		case (MotionEvent.ACTION_DOWN) :
		case(MotionEvent.ACTION_MOVE):
			//model.UpdatePerson();
			return true;
		default :
			return true;
		}
	}
	
}
