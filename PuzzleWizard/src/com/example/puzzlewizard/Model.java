package com.example.puzzlewizard;

import java.util.ArrayList;
import java.util.Vector;

import com.example.puzzlewizard.StateMachine.State;
import com.example.puzzlewizard.User.Spell;

import java.io.Serializable;

public class Model implements Serializable {
//public class Model{

//	private Vector<ModelListener> views = new Vector();
//	private State state = State.Field;
	User user = null;
	private ArrayList<Monster> monsters = new ArrayList();
	StateMachine stateMachine = null;
	//add array of people later
	
	Model(){
		monsters.clear();
	//	views.clear();
	}
	
	public void setUser(User use)
	{
		this.user = use;
	}
	
	public void setMachine(StateMachine machine)
	{
		this.stateMachine = machine;
	}
	
/*	public void addObserver(ModelListener View)
	{
		views.add(View);
	}
	*/
	public void addMonster(Monster monster)
	{
		this.monsters.add(monster);
	}
	
/*	public void notifyObservers(){
		for(ModelListener v : views){
			v.update();
		}
	}
	
	public State getState()
	{
		return this.state;
	}*/
	
	public void UpdateUser(){
		if(user.getLevel() * 20 <= user.getXP())
		{
			user.setXP(0);
			int level = user.getLevel();
			user.setLevel(level + 1);
		}
	}
	
	public void UpdateMonster(Monster monster){
	
		if(stateMachine.getState() == State.Field)
		{
			stateMachine.setState(State.Fight);
		}
		else if(stateMachine.getState() == State.Fight)
		{
			Spell spell = user.getCurrentSpell();
			//grab spell from user
			//check if monster is immune to it-->if so, make damage = 0
			//check if monster is weak to it-->if so, damage doubles
			int hp = monster.getHP();
			monster.setHP(hp - 5);
			if(monster.getHP() <= 0)
			{
				monsters.remove(monster);
				int xp = user.getXP();
				user.setXP(xp + monster.getXP());
				UpdateUser();
				if(monsters.isEmpty())
				{
					stateMachine.setState(State.Field);
				}
			}
			else
			{
				hp = user.getHP();
				user.setHP(hp - monster.getDamage());
			}
		}
//		this.notifyObservers();
	}
}
