package com.example.puzzlewizard;

import java.util.Vector;

public class StateMachine {

	public enum State {Field, Fight, Villager, PostFight, Instructions, Start};
	private State curState = State.Start;
	private Vector<StateListener> listeners = new Vector();
	
	StateMachine()
	{
		listeners.clear();
	}
	
	public void addObserver(StateListener listener)
	{
		listeners.add(listener);
	}
	
	public void notifyObservers(){
		for(StateListener l : listeners){
			l.updateState();
		}
	}
	
	public State getState()
	{
		return this.curState;
	}
	
	public void setState(State state)
	{
		this.curState = state;
		this.notifyObservers();
	}
}
