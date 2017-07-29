package com.example.tttx9android;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.ArrayList;

import engine.tttx9.SubGame;
import engine.tttx9.TTTx9Game;

public class TTTGame extends AppCompatActivity {

    Bundle savedInstanceState;

    ArrayList<FrameLayout> fragments = new ArrayList<>();
    private engine.tttx9.SubGame[] subgames;
    TTTx9Game tttx9Game;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tttgame);
        this.savedInstanceState = savedInstanceState;
        ConstraintLayout layout = (ConstraintLayout) findViewById(R.id.ConstraintLayout); //buitenste container


        tttx9Game = TttGameStore.tttGame;
        subgames = tttx9Game.getGameState().getSubGames();


        for (int i = 0; i < layout.getChildCount(); i++)//gewoon een test, moet uiteindelijk weg/niet hier, hoeven nooit door alle views heen te gaan
        {
            FrameLayout v = (FrameLayout) layout.getChildAt(i); //alle afzondelijke fragments, i
            fragments.add(v);
            for (int j = 0; j < 9; j++) //alle afzonderlijke textviews
            {
                String id = "textView" + j;
                int resID = v.getResources().getIdentifier(id, "id", getPackageName());
                TextView textView = (TextView) v.findViewById(resID);
                textView.setText("" + i + j);
            }

        }
        //getSubgames();
        //for alle i in subgames:
        System.out.println("Subgame length" + subgames.length);
        for(int i=0; i < 9; i++)
        {
            updateSubgame(fragments.get(i), subgames[i]);
        }


    }
    private String convertIdToString(int owner)
    {
        if(owner == 1)
            return "X";
        if(owner == 2)
            return "O";
        else
            return "";

    }


    public void updateSubgame(FrameLayout fragment, SubGame subgame)
    {

        //for each combination of fragment/subgame:
            // for each textview in fragment, ...update textview from subgamedata??

        // for alle 9 strings in fragment:

        for (int j = 0; j < 9; j++) //alle afzonderlijke textviews
        {
            String id = "textView" + j;
            int resID = fragment.getResources().getIdentifier(id, "id", getPackageName());
            TextView textView = (TextView) fragment.findViewById(resID);
            textView.setText(convertIdToString(subgame.getOwner(j)));
        }



    }









}
