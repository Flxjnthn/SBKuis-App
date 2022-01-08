package com.example.uasproject.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;

import java.util.List;

public class Question implements Parcelable {
    private List<Questions> questions;
    private String message;

    protected Question(Parcel in) {
    }

    public static final Creator<Question> CREATOR = new Creator<Question>() {
        @Override
        public Question createFromParcel(Parcel in) {
            return new Question(in);
        }

        @Override
        public Question[] newArray(int size) {
            return new Question[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
    }



    public static Question objectFromData(String str) {

        return new Gson().fromJson(str, Question.class);
    }

    public List<Questions> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Questions> questions) {
        this.questions = questions;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class Questions {
        private String question;
        private String quest_image;
        private int diff_id;

        public Questions(String question, String quest_image, int diff_id) {

            this.question = question;
            this.quest_image = quest_image;
            this.diff_id = diff_id;

        }

        public static Questions objectFromData(String str) {

            return new Gson().fromJson(str, Questions.class);
        }

        public String getQuestion() {
            return question;
        }

        public void setQuestion(String question) {
            this.question = question;
        }

        public String getQuest_image() {
            return quest_image;
        }

        public void setQuest_image(String course_name) {
            this.quest_image = quest_image;
        }



        public int getDiff_id() {
            return diff_id;
        }

        public void setDiff_id(int diff_id) {
            this.diff_id = diff_id;
        }


    }
}
