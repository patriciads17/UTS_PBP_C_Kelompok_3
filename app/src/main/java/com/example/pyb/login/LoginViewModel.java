package com.example.pyb.login;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.pyb.repository.UserRepository;
import com.example.pyb.model.User;

public class LoginViewModel extends ViewModel {
    private final UserRepository mUserRepository;

    public LoginViewModel(Application application) {
        mUserRepository = new UserRepository(application);
    }

    LiveData<User> login(String npm, String password ) {
        return mUserRepository.login(npm, password);
    }
}
