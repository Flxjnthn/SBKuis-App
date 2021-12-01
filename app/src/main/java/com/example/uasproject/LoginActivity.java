package com.example.uasproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    private TextInputLayout textinput_login_email, textinput_login_password;
    private Button button_login;
    private TextView textview_register_here;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textinput_login_email = findViewById(R.id.textInput_login_email);
        textinput_login_password = findViewById(R.id.textInput_login_password);
        button_login = findViewById(R.id.button_login);
        textview_register_here = findViewById(R.id.textView_register_here);

        //Jika Register Here diklick pergi ke RegisterActivity
        textview_register_here.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
            }
        });

        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = textinput_login_email.getEditText().getText().toString().trim();
                String password = textinput_login_password.getEditText().getText().toString().trim();

                if (email.isEmpty()) {
                    textinput_login_email.setError("Silahkan isi kolom email");
                } else {
                    textinput_login_email.setError("");
                }

                if (password.isEmpty()) {
                    textinput_login_password.setError("Silahkan isi kolom password");
                } else {
                    if (password.length() < 8 || password.length() > 20) {
                        textinput_login_password.setError("Kata sandi harus terdiri dari 8 sampai 20 karakter");
                    } else {
                        textinput_login_password.setError("");
                    }
                }
            }
        });

    }
}


