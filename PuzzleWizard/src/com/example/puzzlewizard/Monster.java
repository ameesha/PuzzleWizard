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
