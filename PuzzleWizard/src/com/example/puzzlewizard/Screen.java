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
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.awt.*;

import com.example.puzzlewizard.User.Spell;


public class Screen extends Activity{	
	@SuppressLint("NewApi")
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_screen);
		
		//Intent i = getIntent();
		//model = (Model)i.getSerializableExtra("model");
		//user = (User)i.getSerializableExtra("user");
		//user = new User();
		
		createHPBar();
		createXPBar();
		createPowers();
		createMonster();
	}
	
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_screen, menu);
		return true;
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
		Monster monster = new Monster();
		Point size = new Point();
		getWindowManager().getDefaultDisplay().getSize(size);
		int maxx = size.x;
		int maxy = size.y;
		double x = Math.random() * maxx -75;
		if (x < 5){
			x = 5;
		}
		double y = Math.random() * maxy - 100;
		if (y < 10){
			y = 10;
		}
		//monster.draw(x,y);
		
		ImageView image = (ImageView) findViewById(R.id.monster1);
		/*RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(80,80);
		params.topMargin=(int) x;
		params.leftMargin=(int) y;*/
		
		image.setBackground(monster.draw(x,y));
		image.setX((float) x);
		image.setY((float) y);
		MainActivity.model.addMonster(monster);
	}
}
