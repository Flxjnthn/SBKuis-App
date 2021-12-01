package com.example.uasproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.graphics.Color;
import android.graphics.ImageDecoder;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class LeaderboardActivity extends AppCompatActivity {

    private ImageView imageView_leaderboard_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);

        imageView_leaderboard_back = findViewById(R.id.imageView_leaderboard_back);


        imageView_leaderboard_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}