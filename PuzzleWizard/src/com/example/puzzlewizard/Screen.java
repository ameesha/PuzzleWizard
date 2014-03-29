package com.example.puzzlewizard;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.awt.*;

import com.example.puzzlewizard.StateMachine.State;
import com.example.puzzlewizard.User.Spell;


public class Screen extends Activity{	
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_screen);
		createHPBar();
		createXPBar();
		createPowers();
		createPerson();
		createMonster();
	}
	
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_screen, menu);
		return true;
	}
	
	public void onPause(){
		super.onPause();
	}
	
	public void onResume(){
		super.onResume();
		if (MainActivity.state.getState() == State.PostFight){
			ImageButton ibutton = (ImageButton) findViewById(R.id.monster);
			ibutton.setVisibility(View.GONE);
			ImageButton ibutton2 = (ImageButton) findViewById(R.id.person);
			ibutton2.setEnabled(true);
		}
		createHPBar();
		createXPBar();
		createPowers();
	}
	
	public void createHPBar(){
		TextView hp = (TextView) findViewById(R.id.hp);
		hp.invalidate();
		hp.setText("HP: " + MainActivity.user.getHP());
	}
	
	public void createXPBar(){
		TextView xp = (TextView) findViewById(R.id.xp);
		xp.invalidate();
		xp.setText("XP: " + MainActivity.user.getXP() + "/" + MainActivity.user.getLevel()*20);
	}
	
	public void createPowers(){
		TextView spell = (TextView) findViewById(R.id.spell);
		spell.invalidate();
		spell.setText(""+MainActivity.user.getCurrentSpell());
		if (MainActivity.user.getCurrentSpell() == Spell.Lightning){
			spell.setTextColor(Color.YELLOW);
		}
		else
			spell.setTextColor(Color.BLACK);
	}
	
	@SuppressLint("NewApi") 
	public void createMonster(){
		
		Point size = new Point();
		getWindowManager().getDefaultDisplay().getSize(size);
		int maxx = size.x;
		int maxy = size.y;
		double x = Math.random() * maxx -75;
		double y = Math.random() * maxy - 100;
		if (y > 350){
			y = 350;
		}
		if (y < 50){
			y = 50;
		}
		
		if (x > 950){
			x = 950;
		}
		if (x < 200){
			x = 200;
		}
		if (x >= 600 && x <= 800 && y <= 400 && y >= 300){
			y = 250;
		}
		ImageButton ibutton = (ImageButton) findViewById(R.id.monster);
		ibutton.setX((float) x);
		ibutton.setY((float) y);
	}
	
	@SuppressLint("NewApi")
	public void createPerson(){
		Person person = new Person();
		Point size = new Point();
		getWindowManager().getDefaultDisplay().getSize(size);
		int maxx = size.x;
		int maxy = size.y;
		double x = Math.random() * maxx -75;
		double y = Math.random() * maxy - 100;
		if (y > 350){
			y = 350;
		}
		if (y < 50){
			y = 50;
		}
		
		if (x > 950){
			x = 950;
		}
		if (x < 200){
			x = 200;
		}
		if (x >= 600 && x <= 800 && y <= 400 && y >= 300){
			y = 250;
		}
		ImageButton ibutton = (ImageButton) findViewById(R.id.person);
		ibutton.setX((float) x);
		ibutton.setY((float) y);
		if (MainActivity.state.getState() == State.Field)
			ibutton.setEnabled(false);
/*		ImageView image = (ImageView) findViewById(R.id.person);
		image.setX((float) x);
		image.setY((float) y);
		MainActivity.model.setPerson(true);*/
	}
	
	public void startFight(View view){
		MainActivity.state.setState(State.Fight);
		Intent intent = new Intent(this, Fight.class);
    	startActivity(intent);
	}
	
	public void startPuzzle(View view){
		MainActivity.state.setState(State.Villager);
		Intent intent = new Intent(this, Villager.class);
    	startActivity(intent);
	}
}
