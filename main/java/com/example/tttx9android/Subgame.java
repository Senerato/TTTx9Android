package com.example.tttx9android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class Subgame extends AppCompatActivity {

    public static final String ID = "com.example.tttx9android.ID";

    public Subgame() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subgame);

        Intent intent = getIntent();
        int id = intent.getIntExtra(ID, -1);

        Toast.makeText(this, ""+id, Toast.LENGTH_SHORT).show();
    }


}
