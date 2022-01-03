package com.example.uasproject.view.QuestionView;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.uasproject.R;
import com.example.uasproject.view.HomePageActivity;
import com.example.uasproject.view.ResultView.ResultActivity;

public class QuestionActivity extends AppCompatActivity {

    TextView textView_question_number,textView_choice1,textView_choice2,textView_choice3;
    Button button_next_question;
    int no = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);


        textView_question_number = findViewById(R.id.textView_question_number);
        textView_choice1 = findViewById(R.id.textView_choice1);
        textView_choice2 = findViewById(R.id.textView_choice2);
        textView_choice3 = findViewById(R.id.textView_choice3);
        button_next_question = findViewById(R.id.button_next_question);

        button_next_question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(no >= 10){
                    startActivity(new Intent(getApplicationContext(), ResultActivity.class));
                }else{
                    no++;
                    textView_question_number.setText(String.valueOf(no));
                    textView_choice1.setText("Samuel");
                    textView_choice2.setText("James");
                    textView_choice3.setText("Brody");
                }


            }
        });

    }
}