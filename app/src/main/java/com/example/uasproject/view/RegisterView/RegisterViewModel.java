package com.example.uasproject.view.RegisterView;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.uasproject.model.RegisterResponse;
import com.example.uasproject.repositories.AuthRepository;

public class RegisterViewModel extends AndroidViewModel {
    private AuthRepository authRepository;
    private static final String TAG = "RegisterViewModel";



    public RegisterViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<RegisterResponse> register (String name, String email, String password){
        return authRepository.register(name, email, password);
    }
}
