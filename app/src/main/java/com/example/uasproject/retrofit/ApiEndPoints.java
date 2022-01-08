package com.example.uasproject.retrofit;



import com.example.uasproject.model.Answer;
import com.example.uasproject.model.Difficult;
import com.example.uasproject.model.Question;
import com.example.uasproject.model.RegisterResponse;
import com.example.uasproject.model.Result;
import com.example.uasproject.model.Students;
import com.example.uasproject.model.TokenResponse;
import com.google.gson.JsonObject;

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

    @GET("questions/{question}")
    Call<Question> getQuestionDetail(@Path("question") String code);

    @GET("sbk_10_answer")
    Call<Answer> getAnswer();

    @GET("sbk_10_answer/answer")
    Call<Answer> getAnswerDetail (@Path("sbk_10_answer") String code);

    @GET("sbk_10_difficult")
    Call<Difficult> getDifficult();

    @GET("sbk_10_answer/answer")
    Call<Difficult> getDifficultDetail (@Path("sbk_10_difficult") String code);

    @GET("sbk_10_result")
    Call<Result> getResult();

    @GET("sbk_10_result/result")
    Call<Result> getResultDetail (@Path("sbk_10_result") String code);


    @GET("users")
    Call<Students> getStudent();


}
