package com.example.puzzlewizard;

import com.example.puzzlewizard.StateMachine.State;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {
	
	public static Model model;
	public static User user;
	public static StateMachine state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        model = new Model();
        user = new User();
        state = new StateMachine();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void startGame(View view){
    	state.setState(State.Instructions);
    	Intent intent = new Intent(this, Instructions.class);
    	startActivity(intent);
    	finish();
    }
    
}
