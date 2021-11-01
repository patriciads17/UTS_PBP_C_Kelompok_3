package com.example.pyb.register;

import android.app.Application;

import androidx.lifecycle.ViewModel;

import com.example.pyb.repository.UserRepository;
import com.example.pyb.model.User;

public class RegisterViewModel extends ViewModel {
    private final UserRepository mUserRepository;

    public RegisterViewModel(Application application) {
        mUserRepository = new UserRepository(application);
    }

    public void register(User user) {
        mUserRepository.register(user);
    }
}
