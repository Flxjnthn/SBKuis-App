package com.example.uasproject.retrofit;



import com.example.uasproject.model.Question;
import com.example.uasproject.model.RegisterResponse;
import com.example.uasproject.model.TokenResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;


public interface ApiEndPoints {
    @POST("login")
    @FormUrlEncoded
    Call<TokenResponse> login(@Field("email") String email, @Field("password") String password);

    @POST("register")
    @FormUrlEncoded
    Call<RegisterResponse> register(@Field("name") String name, @Field("email") String email,
                                    @Field("password") String password);

    @GET("questions")
    Call<Question> getQuestion();

    @GET("courses/{question}")
    Call<Question> getQuestionDetail(@Path("question") String code);
}
