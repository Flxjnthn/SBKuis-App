package com.example.uasproject.view.RegisterView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.uasproject.R;
import com.example.uasproject.view.LoginView.LoginActivity;
import com.google.android.material.textfield.TextInputLayout;

public class RegisterActivity extends AppCompatActivity {

    private TextInputLayout textinput_register_username, textinput_register_email, textinput_register_password;
    private ImageView imageview_register_back;
    private Button button_register;
    private RegisterViewModel registerViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        textinput_register_username = findViewById(R.id.textInput_register_username);
        textinput_register_email = findViewById(R.id.textInput_register_email);
        textinput_register_password = findViewById(R.id.textInput_register_password);
        button_register = findViewById(R.id.button_register);
        registerViewModel = new ViewModelProvider(RegisterActivity.this).get(RegisterViewModel.class);


        button_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!textinput_register_username.getEditText().getText().toString().isEmpty()
                        && !textinput_register_email.getEditText().getText().toString().isEmpty()
                        && !textinput_register_password.getEditText().getText().toString().isEmpty() ){
                    String username = textinput_register_username.getEditText().getText().toString().trim();
                    String email = textinput_register_email.getEditText().getText().toString().trim();
                    String password = textinput_register_password.getEditText().getText().toString().trim();

                    registerViewModel.register(username, email, password).observe(RegisterActivity.this, registerResponse -> {
                        if (registerResponse != null) {
                            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                            Toast.makeText(RegisterActivity.this, "Register Success", Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(RegisterActivity.this, "Register Failed", Toast.LENGTH_SHORT).show();

                        }
                    });
                }else{
                    Toast.makeText(RegisterActivity.this, "All field must not empty", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }
}



