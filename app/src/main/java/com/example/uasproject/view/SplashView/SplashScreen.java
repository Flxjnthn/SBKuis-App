package com.example.uasproject.view.SplashView;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.uasproject.R;
import com.example.uasproject.view.LoginView.LoginActivity;

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