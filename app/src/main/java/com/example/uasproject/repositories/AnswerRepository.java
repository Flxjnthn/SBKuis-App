package com.example.uasproject.repositories;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;


import com.example.uasproject.model.Answer;
import com.example.uasproject.retrofit.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AnswerRepository {

    private static AnswerRepository answerRepository;
    private static ProfileRepository profileRepository;
    private RetrofitService apiService;
    private static final String TAG = "AnswerRepository";

    private AnswerRepository(String token) {
        Log.d(TAG, "token: " + token);
        apiService = RetrofitService.getInstance(token);
    }

    public static AnswerRepository getInstance(String token) {
        if (answerRepository == null) {
            answerRepository = new AnswerRepository(token);
        }
        return answerRepository;
    }

    public synchronized void resetInstance() {
        if (answerRepository != null) {
            answerRepository = null;
        } else {
            answerRepository = null;
        }
    }

    public MutableLiveData<Answer> getQuestions() {
        final MutableLiveData<Answer> listAnswer = new MutableLiveData<>();

        apiService.getAnswers().enqueue(new Callback<Answer>() {
            @Override
            public void onResponse(Call<Answer> call, Response<Answer> response) {
                Log.d(TAG, "onResponse: " + response.code());
                if (response.isSuccessful()) {
                    if (response.code() == 200) {
                        if (response.body() != null) {
                            Log.d(TAG, "onResponse" + response.body().getAnswers().size());
                            listAnswer.postValue(response.body());
                        }
                    }
//                    else if (response.code() == 401){
//                        profileRepository.logout();
//                    }
                }
            }



            @Override
            public void onFailure(Call<Answer> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });

        return listAnswer;
    }
}
