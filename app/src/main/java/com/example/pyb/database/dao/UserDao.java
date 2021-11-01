package com.example.pyb.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.pyb.model.User;

@Dao
public interface UserDao {

    @Query("SELECT * FROM user WHERE npm == :npm AND password = :password")
    LiveData<User> login(String npm, String password);

    @Query("SELECT * from user WHERE npm == :npm")
    User getUserProfile(String npm);

    @Insert
    void register(User user);

    @Update
    void update(User user);

}
