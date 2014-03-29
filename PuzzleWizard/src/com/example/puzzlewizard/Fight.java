package com.example.puzzlewizard;

import java.util.Timer;
import java.util.TimerTask;

import com.example.puzzlewizard.StateMachine.State;
import com.example.puzzlewizard.User.Spell;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Fight extends Activity{	
	
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
		createHPBar();
		createXPBar();
		createPowers();
		createMonsters();
	}
	
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_fight, menu);
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
		if (MainActivity.user.getXP() >= MainActivity.user.getLevel()*20){
			MainActivity.user.setLevel(MainActivity.user.getLevel()+1);
			MainActivity.user.setXP(MainActivity.user.getXP()-MainActivity.user.getLevel()*20);
		}
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
				if (y < 100){
					y = 100;
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
				ibutton2.setVisibility(View.INVISIBLE);
				ibutton2.setEnabled(false);
				ibutton3.setVisibility(View.INVISIBLE);
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
				if (y < 100){
					y = 100;
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
				ibutton.setVisibility(View.VISIBLE);
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
				if (y < 100){
					y = 100;
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
				ibutton.setVisibility(View.VISIBLE);
				ibutton.setEnabled(true);
				
				Monster monster = new Monster();
				monster.setHP(5 * MainActivity.user.getLevel());
				MainActivity.model.addMonster(monster);
			}
		}
	}
	
	@SuppressLint("NewApi")
	public void kill1(View view){
		if (MainActivity.user.getCurrentSpell() == Spell.Lightning){
			final RelativeLayout rel = (RelativeLayout) findViewById(R.id.fight_layout);
			rel.setBackground(getResources().getDrawable(R.drawable.fight_lightning));
			
			/*new CountDownTimer(1000,1000){
				public void onFinish(){
					rel.setBackground(getResources().getDrawable(R.drawable.fight_background));
				}
				@Override
				public void onTick(long arg0) {
				}
			}.start();*/
			
			MainActivity.model.monsters.get(0).setHP(MainActivity.model.monsters.get(0).getHP() - MainActivity.user.damage);
			if (MainActivity.model.monsters.get(0).getHP() <= 0){
				ImageButton ibutton = (ImageButton) findViewById(R.id.monster1);
				ibutton.setVisibility(View.GONE);
				numEnemies = numEnemies-1;
				MainActivity.user.setXP(MainActivity.user.getXP()+MainActivity.model.monsters.get(0).getXP());
				createXPBar();
				if (numEnemies == 0){
					MainActivity.state.setState(State.PostFight);
					rel.setBackground(getResources().getDrawable(R.drawable.fight_background));
					
					Intent intent = new Intent(this, Screen.class);
					intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
					startActivity(intent);
					finish();
				}
			}
			else{
				Vibrator v = (Vibrator) this.getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
				v.vibrate(1000);
				MainActivity.user.setHP(MainActivity.user.getHP()-MainActivity.model.monsters.get(0).getDamage());
				createHPBar();
			}
			rel.setBackground(getResources().getDrawable(R.drawable.fight_background));
		}
	}
	
	@SuppressLint("NewApi")
	public void kill2(View view){
		if (MainActivity.user.getCurrentSpell() == Spell.Lightning){
			final RelativeLayout rel = (RelativeLayout) findViewById(R.id.fight_layout);
			rel.setBackground(getResources().getDrawable(R.drawable.fight_lightning));
			
			/*new CountDownTimer(1000,1000){
				public void onFinish(){
					rel.setBackground(getResources().getDrawable(R.drawable.fight_background));
				}
				@Override
				public void onTick(long arg0) {
				}
			}.start();*/
			
			MainActivity.model.monsters.get(1).setHP(MainActivity.model.monsters.get(1).getHP() - MainActivity.user.damage);
			if (MainActivity.model.monsters.get(1).getHP() <= 0){
				ImageButton ibutton = (ImageButton) findViewById(R.id.monster2);
				ibutton.setVisibility(View.GONE);
				numEnemies = numEnemies-1;
				MainActivity.user.setXP(MainActivity.user.getXP()+MainActivity.model.monsters.get(1).getXP());
				createXPBar();
				
				if (numEnemies == 0){
					MainActivity.state.setState(State.PostFight);
					rel.setBackground(getResources().getDrawable(R.drawable.fight_background));
					
					Intent intent = new Intent(this, Screen.class);
					intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
					startActivity(intent);
					finish();
				}
			}
			else{
				Vibrator v = (Vibrator) this.getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
				v.vibrate(1000);
				MainActivity.user.setHP(MainActivity.user.getHP()-MainActivity.model.monsters.get(1).getDamage());
				createHPBar();
			}
			rel.setBackground(getResources().getDrawable(R.drawable.fight_background));
		}
	}
	
	@SuppressLint("NewApi")
	public void kill3(View view){
		if (MainActivity.user.getCurrentSpell() == Spell.Lightning){
			final RelativeLayout rel = (RelativeLayout) findViewById(R.id.fight_layout);
			rel.setBackground(getResources().getDrawable(R.drawable.fight_lightning));
			
			/*new CountDownTimer(1000,1000){
				public void onFinish(){
					rel.setBackground(getResources().getDrawable(R.drawable.fight_background));
				}
				@Override
				public void onTick(long arg0) {
				}
			}.start();*/
			
			MainActivity.model.monsters.get(2).setHP(MainActivity.model.monsters.get(2).getHP() - MainActivity.user.damage);
			if (MainActivity.model.monsters.get(2).getHP() <= 0){
				ImageButton ibutton = (ImageButton) findViewById(R.id.monster3);
				ibutton.setVisibility(View.GONE);
				numEnemies = numEnemies-1;
				MainActivity.user.setXP(MainActivity.user.getXP()+MainActivity.model.monsters.get(2).getXP());
				createXPBar();
				
				if (numEnemies == 0){
					MainActivity.state.setState(State.PostFight);
					rel.setBackground(getResources().getDrawable(R.drawable.fight_background));
					
					Intent intent = new Intent(this, Screen.class);
					intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
					startActivity(intent);
					finish();
				}
			}
			else{
				Vibrator v = (Vibrator) this.getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
				v.vibrate(1000);
				MainActivity.user.setHP(MainActivity.user.getHP()-MainActivity.model.monsters.get(2).getDamage());
				createHPBar();
			}
			rel.setBackground(getResources().getDrawable(R.drawable.fight_background));
		}
	}
}
