package com.example.tttx9android;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import static android.R.attr.duration;


public class TTTSubgameFragment extends Fragment{

    private boolean subGameWon = false;

    public TTTSubgameFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tttsubgame, container, false);
        String menu = getArguments().getString("Menu");
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TTTSubgameFragment.this, Subgame.class);
                startActivity(intent);
            }
        });

        return view;

        // Inflate the layout for this fragment
    }
}
