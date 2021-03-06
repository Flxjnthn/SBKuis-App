package com.example.uasproject.retrofit;

import com.example.uasproject.helper.Const;
import com.example.uasproject.model.Answer;
import com.example.uasproject.model.Difficult;
import com.example.uasproject.model.Question;
import com.example.uasproject.model.RegisterResponse;
import com.example.uasproject.model.Result;
import com.example.uasproject.model.TokenResponse;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {
    private final ApiEndPoints api;
    private static RetrofitService service;
    private static final String TAG = "RetrofitService";

    public RetrofitService(String token){
        OkHttpClient.Builder client = new OkHttpClient.Builder();

        if (token.equals("")){
            client.addInterceptor(chain -> {
                Request request = chain.request().newBuilder()
                        .addHeader("Accept","application/json")
                        .build();
                return chain.proceed(request);
            });
        }else{
            client.addInterceptor(chain -> {
                Request request = chain.request().newBuilder()
                        .addHeader("Accept","application/json")
                        .addHeader("Authorization",token)
                        .build();
                return chain.proceed(request);
            });
        }

        api = new Retrofit.Builder()
                .baseUrl(Const.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build())
                .build().create(ApiEndPoints.class);
    }

    public static RetrofitService getInstance(String token){
        if(service == null){
            service = new RetrofitService(token);
        }else if(!token.equals("")){
            service = new RetrofitService(token);
        }
        return service;
    }

    public Call<TokenResponse> login(String email, String password){
        return api.login(email, password);
    }
    public Call<RegisterResponse> register(String name, String email, String password){
        return api.register(name,email,password);
    }
    public Call<Question> getQuestions(){return api.getQuestion();}
    public Call<Question> getCourseDetail(String code) {return api.getQuestionDetail(code);}

    public Call<Answer> getAnswers(){return api.getAnswer();}
    public Call<Answer> getAnswerDetail(String code) {return api.getAnswerDetail(code);}

    public Call<Difficult> getDifficults(){return api.getDifficult();}
    public Call<Difficult> getDifficultDetail(String code) {return api.getDifficultDetail(code);}

    public Call<Result> getResults(){return api.getResult();}
    public Call<Result> getResultDetail(String code) {return api.getResultDetail(code);}


}
