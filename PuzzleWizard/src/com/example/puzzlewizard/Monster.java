package com.example.puzzlewizard;

import java.util.ArrayList;

import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.widget.ImageView;
import android.widget.RelativeLayout;

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
	
	public static ShapeDrawable draw(double x, double y){
		ShapeDrawable shape = new ShapeDrawable(new OvalShape());
		shape.setBounds((int)x,(int)y,20,20);
		shape.setIntrinsicHeight(20);
		shape.setIntrinsicWidth(30);
		shape.getPaint().setColor(Color.RED);
		return shape;
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
