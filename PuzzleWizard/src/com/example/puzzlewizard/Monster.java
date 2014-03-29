package com.example.puzzlewizard;

import java.util.ArrayList;

public class Monster {
	private int HP = 0;
	private int Damage = 0;
	private int XP = 0;
	private enum Spell {Lightning, Water, Fire, Air, Something};
	private ArrayList<Spell> immunity = new ArrayList();
	private ArrayList<Spell> weakness = new ArrayList();
	
	Monster()
	{
		immunity.clear();
		weakness.clear();
	}
	
	public void setHP(int hp)
	{
		this.HP = hp;
	}
	
	public int getHP()
	{
		return this.HP;
	}
	
	public void setXP(int xp)
	{
		this.XP = xp;
	}
	
	public int getXP()
	{
		return this.XP;
	}
	
	public void setDamage(int damage)
	{
		this.HP = damage;
	}
	
	public int getDamage()
	{
		return this.Damage;
	}
	
	public ArrayList<Spell> getImmunity()
	{
		return (ArrayList<Spell>) this.immunity.clone();
	}
	
	public ArrayList<Spell> getWeakness()
	{
		return (ArrayList<Spell>) this.weakness.clone();
	}
	
	public void addImmunity(Spell spell)
	{
		this.immunity.add(spell);
	}
	
	public void addWeakness(Spell spell)
	{
		this.weakness.add(spell);
	}
 }

/*package com.example.puzzlewizard;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class Monster extends Activity implements SurfaceHolder.Callback{
	private int HP = 0;
	private int Damage = 0;
	private int XP = 0;
	private enum Spell {Lightning, Water, Fire, Air, Something};
	private ArrayList<Spell> immunity = new ArrayList();
	private ArrayList<Spell> weakness = new ArrayList();
	private Context context;
	private SurfaceView view;
	private double x;
	private double y;
	
	Monster(Context context, double x, double y)
	{
		immunity.clear();
		weakness.clear();
		this.context = context;
		view = new SurfaceView(this);
		setContentView(view);
		this.x = x;
		this.y = y;
		view.getHolder().addCallback(this);
	}
	
	@Override
	public void surfaceCreated(SurfaceHolder holder){
		draw(holder);
	}
	
	@Override
	public void surfaceChanged(SurfaceHolder holder, int f, int w, int h){
		draw(holder);
	}
	
	@Override
	public void surfaceDestroyed(SurfaceHolder holder){}
	
	private void draw(SurfaceHolder holder){
		Canvas canvas = holder.lockCanvas();
		Rect rect = new Rect((int) this.x, (int) this.y, 80, 90);
		Bitmap bmap = BitmapFactory.decodeResource(context.getResources(),  R.drawable.monster_ameesha);
		canvas.drawBitmap(bmap, (float) x, (float) y, null);
	}
	
	public void setHP(int hp)
	{
		this.HP = hp;
	}
	
	public int getHP()
	{
		return this.HP;
	}
	
	public void setXP(int xp)
	{
		this.XP = xp;
	}
	
	public int getXP()
	{
		return this.XP;
	}
	
	public void setDamage(int damage)
	{
		this.HP = damage;
	}
	
	public int getDamage()
	{
		return this.Damage;
	}
	
	public ArrayList<Spell> getImmunity()
	{
		return (ArrayList<Spell>) this.immunity.clone();
	}
	
	public ArrayList<Spell> getWeakness()
	{
		return (ArrayList<Spell>) this.weakness.clone();
	}
	
	public void addImmunity(Spell spell)
	{
		this.immunity.add(spell);
	}
	
	public void addWeakness(Spell spell)
	{
		this.weakness.add(spell);
	}
}
*/





/*package com.example.puzzlewizard;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.view.SurfaceHolder;

public class Monster extends SurfaceView implements SurfaceHolder.Callback{
	private int HP = 0;
	private int Damage = 0;
	private int XP = 0;
	private enum Spell {Lightning, Water, Fire, Air, Something};
	private ArrayList<Spell> immunity = new ArrayList();
	private ArrayList<Spell> weakness = new ArrayList();
	private Context context;
	
	Monster(Context context)
	{
		immunity.clear();
		weakness.clear();
		this.context = context;
	}
	
	/*public static ShapeDrawable draw(double x, double y){
		ShapeDrawable shape = new ShapeDrawable(new OvalShape());
		shape.setBounds((int)x,(int)y,80,90);
		shape.setIntrinsicHeight(80);
		shape.setIntrinsicWidth(90);
		shape.getPaint().setColor(Color.RED);
		return shape;
	}*//*
	
	@SuppressLint("WrongCall")
	public void draw(double x, double y, SurfaceHolder holder){
		Canvas canvas;
		canvas = null;
	//	canvas = this.surfaceHolder.lockCanvas();
	//	synchronized (surfaceHolder){
			this.onDraw(canvas, x, y);
	//	}
	}
	
	protected void onDraw(Canvas canvas, double x, double y){
		Rect rect = new Rect((int) x, (int) y, 80, 90);
		Paint paint = new Paint();
		canvas.drawRect(rect, paint);
		Bitmap bmap = BitmapFactory.decodeResource(context.getResources(),  R.drawable.monster_ameesha);
		canvas.drawBitmap(bmap, (float) x, (float) y, null);
	}
	
	public void setHP(int hp)
	{
		this.HP = hp;
	}
	
	public int getHP()
	{
		return this.HP;
	}
	
	public void setXP(int xp)
	{
		this.XP = xp;
	}
	
	public int getXP()
	{
		return this.XP;
	}
	
	public void setDamage(int damage)
	{
		this.HP = damage;
	}
	
	public int getDamage()
	{
		return this.Damage;
	}
	
	public ArrayList<Spell> getImmunity()
	{
		return (ArrayList<Spell>) this.immunity.clone();
	}
	
	public ArrayList<Spell> getWeakness()
	{
		return (ArrayList<Spell>) this.weakness.clone();
	}
	
	public void addImmunity(Spell spell)
	{
		this.immunity.add(spell);
	}
	
	public void addWeakness(Spell spell)
	{
		this.weakness.add(spell);
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		
	}
 }
*/