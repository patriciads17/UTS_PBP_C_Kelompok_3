package com.example.pyb.database;

import android.content.Context;

public class UserDatabase {
    private Context context;

    private static UserDatabase userDatabase;
    private UserRoomDatabase appDatabase;

    public UserDatabase(Context context) {
        this.context = context;
        this.appDatabase = appDatabase;
    }

    public static synchronized UserDatabase getInstance(Context context){
        if (userDatabase == null){
            userDatabase = new UserDatabase(context);
        }
        return  userDatabase;
    }

    public UserRoomDatabase getAppDatabase(){
        return appDatabase;
    }
}

