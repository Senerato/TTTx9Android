package com.example.tttx9android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import engine.tttx9.Player;
import engine.tttx9.TTTx9Game;

public class MainActivity extends AppCompatActivity {

    private TTTx9Game tttGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Player p1 = new engine.tttx9_ai.IteratingAI("Iterating AI1");
        Player p2 = new engine.tttx9_ai.IteratingAI("Iterating AI1");
        TttGameStore.tttGame = new TTTx9Game(p1, p2);
        tttGame = TttGameStore.tttGame;

    }

    public void startButton(View v) {
        Intent intent = new Intent(MainActivity.this, TTTGame.class);


        tttGame.play();
        startActivity(intent);
    }

}
