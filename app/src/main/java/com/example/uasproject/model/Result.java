package com.example.uasproject.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;

import java.util.List;

public class Result implements Parcelable {
    private List<Result.Results> results;
    private String message;
    protected Result(Parcel in) {
    }

    public static final Creator<Result> CREATOR = new Creator<Result>() {
        @Override
        public Result createFromParcel(Parcel in) {
            return new Result(in);
        }

        @Override
        public Result[] newArray(int size) {
            return new Result[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
    }

    public static Result objectFromData(String str) {

        return new Gson().fromJson(str, Result.class);
    }

    public List<Result.Results> getResults() {
        return results;
    }

    public void setAnswers(List<Result.Results> results) {
        this.results = results;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class Results {
        private int ID_result;
        private String result;
        private int ID;
        private int id_diff;

        public Results(int ID_result, String result, int ID, int id_diff) {

            this.ID_result = ID_result;
            this.result = result;
            this.ID = ID;
            this.id_diff = id_diff;

        }

        public static Result.Results objectFromData(String str) {

            return new Gson().fromJson(str, Result.Results.class);
        }

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }

        public int getID_result() {
            return ID_result;
        }

        public void setID_result(int ID_result) {
            this.ID_result = ID_result;
        }

        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public int getId_diff() {
            return id_diff;
        }

        public void setId_diff(int id_diff) {
            this.id_diff = id_diff;
        }


    }
}
