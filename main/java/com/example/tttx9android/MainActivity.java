package com.example.tttx9android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void someFancyMethod(View v) {
        Intent intent = new Intent(MainActivity.this, TTTGame.class);
        startActivity(intent);
    }
}
