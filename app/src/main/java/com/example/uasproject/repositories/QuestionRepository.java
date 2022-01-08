package com.example.uasproject.repositories;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.uasproject.model.Question;
import com.example.uasproject.retrofit.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuestionRepository {
    private static QuestionRepository questionRepository;
    private static ProfileRepository profileRepository;
    private RetrofitService apiService;
    private static final String TAG = "QuestionRepository";

    private QuestionRepository(String token) {
        Log.d(TAG, "token: " + token);
        apiService = RetrofitService.getInstance(token);
    }

    public static QuestionRepository getInstance(String token) {
        if (questionRepository == null) {
            questionRepository = new QuestionRepository(token);
        }
        return questionRepository;
    }

    public synchronized void resetInstance() {
        if (questionRepository != null) {
            questionRepository = null;
        } else {
            questionRepository = null;
        }
    }

    public MutableLiveData<Question> getQuestions() {
        final MutableLiveData<Question> listQuestion = new MutableLiveData<>();

        apiService.getQuestions().enqueue(new Callback<Question>() {
            @Override
            public void onResponse(Call<Question> call, Response<Question> response) {
                Log.d(TAG, "onResponse: " + response.code());
                if (response.isSuccessful()) {
                    if (response.code() == 200) {
                        if (response.body() != null) {
                            Log.d(TAG, "onResponse" + response.body().getQuestions().size());
                            listQuestion.postValue(response.body());
                        }
                    }
//                    else if (response.code() == 401){
//                        profileRepository.logout();
//                    }
                }
            }



            @Override
            public void onFailure(Call<Question> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });

        return listQuestion;
    }
}
