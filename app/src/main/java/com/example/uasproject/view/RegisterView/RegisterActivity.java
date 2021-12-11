package com.example.uasproject.view.RegisterView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.uasproject.R;
import com.google.android.material.textfield.TextInputLayout;

public class RegisterActivity extends AppCompatActivity {

    private TextInputLayout textinput_register_username, textinput_register_email, textinput_register_password;
    private ImageView imageview_register_back;
    private Button button_register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        textinput_register_username = findViewById(R.id.textInput_register_username);
        textinput_register_email = findViewById(R.id.textInput_register_email);
        textinput_register_password = findViewById(R.id.textInput_register_password);
        button_register = findViewById(R.id.button_register);

        button_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = textinput_register_username.getEditText().getText().toString().trim();
                String email = textinput_register_email.getEditText().getText().toString().trim();
                String password = textinput_register_password.getEditText().getText().toString().trim();


                if (username.isEmpty()) {
                    textinput_register_username.setError("Silahkan isi kolom username");
                    return;
                } else {
                    textinput_register_username.setError("");
                }

                if (email.isEmpty()) {
                    textinput_register_email.setError("Silahkan isi kolom email");
                    return;
                } else {
                    textinput_register_email.setError("");
                }


                if (password.isEmpty()) {
                    textinput_register_password.setError("Silahkan isi kolom password");
                    return;
                } else {
                    if (password.length() < 8 || password.length() > 20) {
                        textinput_register_password.setError("Kata sandi harus terdiri dari 8 sampai 20 karakter");
                    } else {
                        textinput_register_password.setError("");
                    }
                }
            }
        });

    }
}