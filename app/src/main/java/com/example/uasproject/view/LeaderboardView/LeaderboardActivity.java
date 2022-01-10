package com.example.uasproject.view.LeaderboardView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.graphics.Color;
import android.graphics.ImageDecoder;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.uasproject.R;

public class LeaderboardActivity extends AppCompatActivity {

    private ImageView imageView_leaderboard_back;
    private TextView textView_top1_leaderboard,textView_top2_leaderboard,textView_top3_leaderboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);


        imageView_leaderboard_back = findViewById(R.id.imageView_leaderboard_back);
        textView_top1_leaderboard = findViewById(R.id.textView_top1_leaderboard);
        textView_top2_leaderboard = findViewById(R.id.textView_top2_leaderboard);
        textView_top3_leaderboard = findViewById(R.id.textView_top3_leaderboard);

        textView_top1_leaderboard.setText("Bryan");
        textView_top2_leaderboard.setText("Renald");
        textView_top3_leaderboard.setText("Felix");

        imageView_leaderboard_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

    }
}