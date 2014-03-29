package com.example.puzzlewizard;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import java.awt.*;


public class Screen extends Activity{
	
	User user = new User();
	@SuppressLint("NewApi")
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_screen);
		createHPBar();
		createXPBar();
		createPowers();
	}
	
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_screen, menu);
		return true;
	}
	
	public void createHPBar(){
		TextView hp = (TextView) findViewById(R.id.hp);
		hp.invalidate();
		hp.setText("HP: " + user.getHP());
		//"HP: " + user.getHP());
	}
	
	public void createXPBar(){
		TextView xp = (TextView) findViewById(R.id.xp);
		xp.invalidate();
		xp.setText("XP: " + user.getXP() + "/" + user.getLevel()*20);
	}
	
	public void createPowers(){
		TextView spell = (TextView) findViewById(R.id.spell);
		spell.invalidate();
		spell.setText(""+user.getCurrentSpell());
	}
	
/*	public void SplashScreen(Context context, AttributeSet attrs){
		super(context,attrs);
		setBackgroundResource(R.drawable.background);
	}*/
}
