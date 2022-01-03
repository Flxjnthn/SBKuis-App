package com.example.uasproject.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.uasproject.R;
import com.example.uasproject.view.LeaderboardView.LeaderboardActivity;
import com.example.uasproject.view.QuestionView.QuestionActivity;

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

        cardView_easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), QuestionActivity.class));
            }
        });

        cardView_medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), QuestionActivity.class));
            }
        });

        cardView_hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), QuestionActivity.class));
            }
        });
    }
}