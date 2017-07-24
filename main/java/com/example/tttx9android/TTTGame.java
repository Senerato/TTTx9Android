package com.example.tttx9android;

import android.app.Fragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TTTGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tttgame);

        for (int i = 0; i < 1; i++) {

            String s = "TTTSubgameFragment" + i;

            Fragment fragment = getFragmentManager().findFragmentByTag(s);
            //fragment.getView();
            fragment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(TTTGame.this, Subgame.class);
                    startActivity(intent);
                }
            });
        }
    }
}
