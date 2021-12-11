package com.example.uasproject.retrofit;



import com.example.uasproject.model.RegisterResponse;
import com.example.uasproject.model.TokenResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.POST;


public interface ApiEndPoints {
    @POST("login")
    Call<TokenResponse> login(@Field("email") String email, @Field("password") String password);

    @POST("register")
    Call<RegisterResponse> register(@Field("name") String name, @Field("email") String email,
                                    @Field("password") String password,
                                    @Field("password_confirmation") String password_confirmation);
}
