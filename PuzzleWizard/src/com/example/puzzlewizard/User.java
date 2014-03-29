package com.example.puzzlewizard;

import java.util.ArrayList;
//import java.io.Serializable;

//public class User implements Serializable{
public class User{
	private int HP = 20;
	private int XP = 0;
	private int Level = 1;
	public int damage = 3;
	//private int XPtoLevel = 0;
	public enum Spell {Lightning, Water, Fire, Air, Something};
	private Spell currentSpell = Spell.Lightning;
	private ArrayList<Spell> spells = new ArrayList();
	private enum Equipment {Shield, Sword, Something};
	private ArrayList<Equipment> equipment = new ArrayList();
	
	User()
	{
		spells.clear();
		equipment.clear();
	}
	
	public ArrayList<Spell> getSpells()
	{
		return (ArrayList<Spell>) this.spells.clone();
	}
	
	public ArrayList<Equipment> getEquipment()
	{
		return (ArrayList<Equipment>) this.equipment.clone();
	}
	
	public int getHP()
	{
		return this.HP;
	}
	
	public int getXP()
	{
		return this.XP;
	}
	
	public int getLevel()
	{
		return this.Level;
	}
	
	/*public int getXPtoLevel()
	{
		return this.XPtoLevel;
	}*/

	public void setSpells(Spell spell)
	{
		 this.spells.add(spell);
	}
	
	public void setEquipment(Equipment equip)
	{
		this.equipment.add(equip);
	}
	
	public void setHP(int hp)
	{
		this.HP = hp;
	}
	
	public void setXP(int xp)
	{
		this.XP = xp;
	}
	
	public void setLevel(int level)
	{
		this.Level = level;
	}
	
	/*public void setXPtoLevel(int xp)
	{
		this.XPtoLevel = xp;
	}*/
	
	public void setCurrentSpell(Spell spell){
		this.currentSpell = spell;
	}
	
	public Spell getCurrentSpell(){
		return this.currentSpell;
	}
}
