package com.example.uasproject.repositories;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.uasproject.model.RegisterResponse;
import com.example.uasproject.model.TokenResponse;
import com.example.uasproject.retrofit.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthRepository {
    private static AuthRepository authRepository;
    private RetrofitService apiService;
    private static final String TAG = "AuthRepository";

    private AuthRepository(){
        apiService = RetrofitService.getInstance("");
    }

    public static  AuthRepository getInstance(){
        if(authRepository == null){
            authRepository = new AuthRepository();
        }
        return authRepository;
    }

    public MutableLiveData<TokenResponse> login(String email, String password){
        MutableLiveData<TokenResponse> tokenResponse = new MutableLiveData<>();

        apiService.login(email, password).enqueue(new Callback<TokenResponse>() {
            @Override
            public void onResponse(Call<TokenResponse> call, Response<TokenResponse> response) {
                if(response.isSuccessful()){
                    Log.d(TAG, "onRensponse: "+response.code());
                    if(response.code() == 200){
                        if(response.body() != null){
                            Log.d(TAG, "onResponse: "+response.body().getAccess_token());
                            tokenResponse.postValue(response.body());
                            Log.d(TAG, "Test");
                        }
                    }
                }else {
                    Log.d(TAG, "onResponse: "+response.code());

                }
            }

            @Override
            public void onFailure(Call<TokenResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: "+ t.getMessage());
            }
        });

        return tokenResponse;
    }

    public MutableLiveData<RegisterResponse> register(String name, String email, String password){
        MutableLiveData<RegisterResponse> registerResponse = new MutableLiveData<>();
        apiService.register(name, email, password).enqueue(new Callback<RegisterResponse>(){
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                if(response.isSuccessful()){
                    Log.d(TAG, "onRensponse: "+response.code());
                    if(response.code() == 200){
                        if(response.body() != null){
                            Log.d(TAG, "onResponse: "+response.body());
                            registerResponse.postValue(response.body());
                        }
                    }
                }else {
                    Log.d(TAG, "onResponse: "+response.code());
                }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: "+ t.getMessage());
            }
        });

        return registerResponse;
    }
}
