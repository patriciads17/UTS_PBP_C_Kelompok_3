package com.example.pyb.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.pyb.database.UserRoomDatabase;
import com.example.pyb.database.dao.UserDao;
import com.example.pyb.model.User;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UserRepository {
    private final UserDao userDao;
    private final ExecutorService executorService;

    public UserRepository(Application application) {
        executorService = Executors.newSingleThreadExecutor();

        UserRoomDatabase db = UserRoomDatabase.getDatabase(application);
        userDao = db.userDao();
    }

    public void register(final User user) {
        executorService.execute(() -> userDao.register(user));
    }

    public LiveData<User> login(String npm, String password) {
        return userDao.login(npm, password);
    }

}
