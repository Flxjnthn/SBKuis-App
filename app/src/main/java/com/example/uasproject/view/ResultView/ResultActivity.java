package com.example.uasproject.view.ResultView;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.uasproject.R;
import com.example.uasproject.view.HomePageActivity;

public class ResultActivity extends AppCompatActivity {

    private Button button_goToHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        button_goToHome = findViewById(R.id.button_goToHome);

        button_goToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), HomePageActivity.class));
            }
        });

    }
}