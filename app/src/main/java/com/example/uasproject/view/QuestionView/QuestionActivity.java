package com.example.uasproject.view.QuestionView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.uasproject.R;
import com.example.uasproject.view.HomePageActivity;
import com.example.uasproject.view.ResultView.ResultActivity;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class QuestionActivity extends AppCompatActivity {

    TextView textView_question_number,textView_question,textView_question_difficulty,
            textView_choice1,textView_choice2,textView_choice3,
    textView_countDown;
    Button button_next_question;
    private CountDownTimer countDownTimer;
    private ProgressBar questionProgress;
    private CardView cardView_choice1,cardView_choice2,cardView_choice3;
    int no = 1;
    int quest=10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        textView_question = findViewById(R.id.textViewQuestion);
        textView_question_number = findViewById(R.id.textView_question_number);
        textView_question_difficulty = findViewById(R.id.textView_question_difficulty);
        textView_countDown = findViewById(R.id.textView_countDown);
        textView_choice1 = findViewById(R.id.textView_choice1);
        textView_choice2 = findViewById(R.id.textView_choice2);
        textView_choice3 = findViewById(R.id.textView_choice3);
        button_next_question = findViewById(R.id.button_next_question);
        questionProgress = findViewById(R.id.questionProgress);
        cardView_choice1 = findViewById(R.id.cardView_choice1);
        cardView_choice2 = findViewById(R.id.cardView_choice2);
        cardView_choice3 = findViewById(R.id.cardView_choice3);

        button_next_question.setVisibility(View.GONE);
        startTimer(quest);


    }
    private void startTimer ( int questionNumber){


        textView_countDown.setText(String.valueOf(questionNumber));

        int finalQuestionNumber = questionNumber;
        countDownTimer = new CountDownTimer(finalQuestionNumber, 1000) {
            @Override
            public void onTick(long l) {
                textView_countDown.setText(l / 1000 + "");

                //Progress in percent

                Long percent = l / finalQuestionNumber * 10;
                questionProgress.setProgress(percent.intValue());


            }

            @Override
            public void onFinish() {
                textView_countDown.setVisibility(View.GONE);
                Toast.makeText(getApplicationContext(),
                        "Times Up", Toast.LENGTH_SHORT).show();
                questionProgress.setVisibility(View.VISIBLE);
            }
        };





        button_next_question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(no >= 10){

                    startActivity(new Intent(getApplicationContext(), ResultActivity.class));
                }else if(no >=9){
                    no++;
                    textView_question.setText("Jenis-jenis benda pakai yang dibuat dengan menggunakan teknik butsir dan cetak, kecuali…?.");
                    textView_choice1.setText("Meja Ukir");
                    textView_choice2.setText("Meja Pahat");
                    textView_choice3.setText("Meja Mejaan");
                    textView_question_number.setText(String.valueOf(no));
                    button_next_question.setText("Result");
                    button_next_question.setVisibility(View.GONE);
                }else if(no >=8){
                    no++;
                    textView_question.setText("Berikut adalah instrument musik yang dibunyikan dengan cara dipukul, kecuali");
                    textView_question_number.setText(String.valueOf(no));
                    textView_choice1.setText("Talempong");
                    textView_choice2.setText("Rebah");
                    textView_choice3.setText("Gong");
                    button_next_question.setVisibility(View.GONE);
                }else if(no >=7){
                    no++;
                    textView_question.setText("Gamelan gegrantangan merupakan nama lain dari");
                    textView_question_number.setText(String.valueOf(no));
                    textView_choice1.setText("Gamelan gong gede");
                    textView_choice2.setText("Gamelan jogged bumbung");
                    textView_choice3.setText("Gamelan sekaten");
                    button_next_question.setVisibility(View.GONE);
                }else if(no >=6){
                    no++;
                    textView_question.setText("Fungsi musik tradisional antara lain ?");
                    textView_question_number.setText(String.valueOf(no));
                    textView_choice1.setText("Penyalur kebudayaan");
                    textView_choice2.setText("Sarana Ekspresi");
                    textView_choice3.setText("Sarana Tarian");
                    button_next_question.setVisibility(View.GONE);
                }else if(no >=5){
                    no++;
                    textView_question.setText("Berikut ini merupakan contoh benda seni rupa terapan yang termasuk benda pakai, kecuali…?.");
                    textView_question_number.setText(String.valueOf(no));
                    textView_choice1.setText("Perajin");
                    textView_choice2.setText("Cangkir");
                    textView_choice3.setText("Mangkuk");
                    button_next_question.setVisibility(View.GONE);
                }else if(no >=4){
                    no++;
                    textView_question.setText("Orang yang membuat benda-benda kerajinan disebut…?");
                    textView_question_number.setText(String.valueOf(no));
                    textView_choice1.setText("Penulis");
                    textView_choice2.setText("Perajin");
                    textView_choice3.setText("Pelawak");
                    button_next_question.setVisibility(View.GONE);
                }else if(no >=3){
                    no++;
                    textView_question.setText("Pembuatan karya seni rupa terapan menonjolkan beberapa hal di bawah ini, kecuali….");
                    textView_question_number.setText(String.valueOf(no));
                    textView_choice1.setText("Keterampilan");
                    textView_choice2.setText("Kekuatan");
                    textView_choice3.setText("Kecekatan Tangan");
                    button_next_question.setVisibility(View.GONE);
                }else if(no >=2){
                    no++;
                    textView_question.setText("Benda-benda seni rupa terapan sering juga disebut ...");
                    textView_question_number.setText(String.valueOf(no));
                    textView_choice1.setText("Seni rupa murni");
                    textView_choice2.setText("Seni Kriya");
                    textView_choice3.setText("Seni Terapan");
                    button_next_question.setVisibility(View.GONE);
                }else if(no >=1){
                    no++;
                    textView_question.setText("Alat-alat yang diciptakan oleh manusia di zaman prasejarah digunakan untuk…?.");
                    textView_question_number.setText(String.valueOf(no));
                    textView_choice1.setText("Hiburan saja");
                    textView_choice2.setText("Berburu");
                    textView_choice3.setText("Mempertahankan Hidup");
                    button_next_question.setVisibility(View.GONE);
                }




            }
        });

        cardView_choice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button_next_question.setVisibility(View.VISIBLE);
            }
        });
        cardView_choice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button_next_question.setVisibility(View.VISIBLE);
            }
        });
        cardView_choice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button_next_question.setVisibility(View.VISIBLE);
            }
        });


    }
}