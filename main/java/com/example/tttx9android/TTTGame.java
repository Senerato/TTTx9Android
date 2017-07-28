package com.example.tttx9android;

import android.app.Fragment;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

public class TTTGame extends AppCompatActivity {

    Bundle savedInstanceState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tttgame);
        this.savedInstanceState = savedInstanceState;
        ConstraintLayout layout = (ConstraintLayout) findViewById(R.id.ConstraintLayout); //buitenste container

        for(int i=0; i< layout.getChildCount(); i++)//gewoon een test, moet uiteindelijk weg/niet hier, hoeven nooit door alle views heen te gaan
        {
            FrameLayout v = (FrameLayout)layout.getChildAt(i); //alle afzondelijke fragments, i

            for(int j=0; j<9; j++) //alle afzonderlijke textviews
            {
                String id = "textView"+j;
                int resID = v.getResources().getIdentifier(id, "id", getPackageName());
                TextView textView = (TextView) v.findViewById(resID);
                textView.setText(""+i+j);
            }

        }





    }




}
