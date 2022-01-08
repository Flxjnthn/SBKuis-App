package com.example.uasproject.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.uasproject.model.Difficult;
import com.example.uasproject.retrofit.RetrofitService;
import com.google.gson.Gson;

import java.util.List;

public class Difficult implements Parcelable{
    private List<Difficult.Difficults> difficults;
    private String message;

    protected Difficult(Parcel in) {
    }

    public static final Creator<Difficult> CREATOR = new Creator<Difficult>() {
        @Override
        public Difficult createFromParcel(Parcel in) {
            return new Difficult(in);
        }

        @Override
        public Difficult[] newArray(int size) {
            return new Difficult[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
    }

    public static Answer objectFromData(String str) {

        return new Gson().fromJson(str, Answer.class);
    }

    public List<Difficult.Difficults> getDifficults() {
        return difficults;
    }

    public void setDifficults(List<Difficult.Difficults> difficults) {
        this.difficults = difficults;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class Difficults {
        private int ID_diff;
        private String difficulty;


        public Difficults(int ID_diff, String difficulty) {

            this.ID_diff = ID_diff;
            this.difficulty = difficulty;

        }

        public static Difficult.Difficults objectFromData(String str) {

            return new Gson().fromJson(str, Difficult.Difficults.class);
        }

        public int getID_diff() {
            return ID_diff;
        }

        public void setID_diff(int ID_diff) {
            this.ID_diff = ID_diff;
        }

        public String getDifficulty() {
            return difficulty;
        }

        public void setDifficulty(String difficulty) {
            this.difficulty = difficulty;
        }



    }
}
