package com.example.uasproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class HomePageActivity extends AppCompatActivity {

    private CardView cardView_easy, cardView_medium, cardView_hard;
    private ImageView imageView_leaderboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        imageView_leaderboard = findViewById(R.id.imageView_leaderboard);
        cardView_easy = findViewById(R.id.cardView_easy);
        cardView_medium = findViewById(R.id.cardView_medium);
        cardView_hard = findViewById(R.id.cardView_hard);

        imageView_leaderboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), LeaderboardActivity.class));
            }
        });
    }
}