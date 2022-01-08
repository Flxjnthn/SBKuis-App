package com.example.uasproject.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.uasproject.model.Answer;
import com.example.uasproject.retrofit.RetrofitService;
import com.google.gson.Gson;

import java.util.List;

public class Answer implements Parcelable {
    private List<Answer.Answers> answers;
    private String message;

    protected Answer(Parcel in) {
    }

    public static final Creator<Answer> CREATOR = new Creator<Answer>() {
        @Override
        public Answer createFromParcel(Parcel in) {
            return new Answer(in);
        }

        @Override
        public Answer[] newArray(int size) {
            return new Answer[size];
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

    public List<Answer.Answers> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer.Answers> answers) {
        this.answers = answers;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class Answers {
        private int ID_answer;
        private String answer;
        private int is_correct;
        private int quest_id;

        public Answers(int ID_answer, String question, int is_correct, int quest_id) {

            this.ID_answer = ID_answer;
            this.answer = answer;
            this.is_correct = is_correct;
            this.quest_id = quest_id;

        }

        public static Answer.Answers objectFromData(String str) {

            return new Gson().fromJson(str, Answer.Answers.class);
        }

        public String getAnswer() {
            return answer;
        }

        public void setAnswer(String answer) {
            this.answer = answer;
        }

        public int getIs_correct() {
            return is_correct;
        }

        public void setIs_correct(int is_correct) {
            this.is_correct = is_correct;
        }

        public int getQuest_id() {
            return quest_id;
        }

        public void setQuest_id(int quest_id) {
            this.quest_id = quest_id;
        }

        public int getID_answer() {
            return ID_answer;
        }

        public void setID_answer(int ID_answer) {
            this.ID_answer = ID_answer;
        }


    }
}
