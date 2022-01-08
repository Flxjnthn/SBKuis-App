package com.example.uasproject.repositories;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.uasproject.model.Question;
import com.example.uasproject.model.Result;
import com.example.uasproject.retrofit.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResultRepository {
    private static ResultRepository resultRepository;
    private static ProfileRepository profileRepository;
    private RetrofitService apiService;
    private static final String TAG = "QuestionRepository";

    private ResultRepository(String token) {
        Log.d(TAG, "token: " + token);
        apiService = RetrofitService.getInstance(token);
    }

    public static ResultRepository getInstance(String token) {
        if (resultRepository == null) {
            resultRepository = new ResultRepository(token);
        }
        return resultRepository;
    }

    public synchronized void resetInstance() {
        if (resultRepository != null) {
            resultRepository = null;
        } else {
            resultRepository = null;
        }
    }

    public MutableLiveData<Result> getResults() {
        final MutableLiveData<Result> listResult= new MutableLiveData<>();

        apiService.getResults().enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Log.d(TAG, "onResponse: " + response.code());
                if (response.isSuccessful()) {
                    if (response.code() == 200) {
                        if (response.body() != null) {
                            Log.d(TAG, "onResponse" + response.body().getResults().size());
                            listResult.postValue(response.body());
                        }
                    }
//                    else if (response.code() == 401){
//                        profileRepository.logout();
//                    }
                }
            }



            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });

        return listResult;
    }
}
