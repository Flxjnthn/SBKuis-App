package com.example.uasproject.view.LoginView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.uasproject.R;
import com.example.uasproject.helper.SharedPreferenceHelper;
import com.example.uasproject.view.HomePageActivity;
import com.example.uasproject.view.RegisterView.RegisterActivity;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    private TextInputLayout textinput_login_email, textinput_login_password;
    private Button button_login;
    private TextView textview_register_here;
    private LoginViewModel loginViewModel;
    private SharedPreferenceHelper helper;
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
        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        helper = SharedPreferenceHelper.getInstance(LoginActivity.this);

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

                    loginViewModel.login(email, password).observe(LoginActivity.this, tokenResponse -> {
                        if (tokenResponse != null){
                            helper.saveAccessToken(tokenResponse.getAuthorization());
                            startActivity(new Intent(getApplicationContext(), HomePageActivity.class));
                            Toast.makeText(LoginActivity.this,"Login Success", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(LoginActivity.this,"Login Failed", Toast.LENGTH_SHORT).show();
                        }
                    });

                }

            }
        });

    }
}


