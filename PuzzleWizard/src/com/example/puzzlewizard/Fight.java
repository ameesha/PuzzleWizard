package com.example.puzzlewizard;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageButton;

public class Fight extends Overview{	
	
	int numEnemies;
	@SuppressLint("NewApi")
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fight);
		int max = 3;
		numEnemies = (int) (Math.random() * max);
		if (numEnemies == 0){
			numEnemies = 1;
		}
		createMonsters();
	}
	
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_fight, menu);
		return true;
	}
	
	@SuppressLint("NewApi")
	public void createMonsters(){
		for (int i = 1; i <= numEnemies; i++){
			if (i == 1){
				ImageButton ibutton = (ImageButton) findViewById(R.id.monster1);
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
				ibutton.setX((float)x);
				ibutton.setY((float)y);
				ibutton.setVisibility(1);
				ibutton.setEnabled(true);
				ImageButton ibutton2 = (ImageButton) findViewById(R.id.monster2);
				ImageButton ibutton3 = (ImageButton) findViewById(R.id.monster3);
				ibutton2.setVisibility(0);
				ibutton2.setEnabled(false);
				ibutton3.setVisibility(0);
				ibutton3.setEnabled(false);
				
				Monster monster = new Monster();
				monster.setHP(5 * MainActivity.user.getLevel());
				MainActivity.model.addMonster(monster);
				
			}
			else if (i == 2){
				ImageButton ibutton = (ImageButton) findViewById(R.id.monster2);
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
				ibutton.setX((float)x);
				ibutton.setY((float)y);
				ibutton.setVisibility(1);
				ibutton.setEnabled(true);
				
				Monster monster = new Monster();
				monster.setHP(5 * MainActivity.user.getLevel());
				monster.setDamage(2 *MainActivity.user.getLevel());
				MainActivity.model.addMonster(monster);
			}
			else{
				ImageButton ibutton = (ImageButton) findViewById(R.id.monster3);
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
				ibutton.setX((float)x);
				ibutton.setY((float)y);
				ibutton.setVisibility(1);
				ibutton.setEnabled(true);
				
				Monster monster = new Monster();
				monster.setHP(5 * MainActivity.user.getLevel());
				MainActivity.model.addMonster(monster);
			}
		}
	}
	
	public void kill1(){
	//	MainActivity.model.
	}
}
