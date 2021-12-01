package com.example.uasproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(() -> {
            //habis splash screen lalu pindah ke login
            Intent login = new Intent(this, LoginActivity.class);
            startActivity(login);
            finish();
        },1500);
    }
}