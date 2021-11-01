package com.example.pyb.database;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.pyb.model.User;

public class UserPreferences {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context context;
    private static final String PREFERENCE_NPM_LOGIN = "PREFERENCE_NPM_LOGIN";

    /* Mendefinisikan Key */
    public static final String IS_LOGIN = "isLogin";
    public static final String KEY_NAME = "name";
    public static final String KEY_NPM = "npm";
    public static final String KEY_MAIL = "mail";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_ADDRESS = "address";
    public static final String KEY_JSON_ADDRESS = "json_address";
    public static final String KEY_PROFIL_PIC = "profil_pic";
    public static final String KEY_PHONE_NUM = "phone_num";

    public UserPreferences(Context context) {
        this.context = context;

        this.sharedPreferences = context.getSharedPreferences("userPreferences", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void setLogin(User user) {
        editor.putBoolean(IS_LOGIN, true);
        editor.putString(KEY_NAME, user.getName());
        editor.putString(KEY_NPM, user.getNpm());
        editor.putString(KEY_MAIL, user.getMail());
        editor.putString(KEY_PASSWORD, user.getPassword());
        editor.putString(KEY_JSON_ADDRESS,user.getJsonAddress());
        editor.putString(KEY_ADDRESS,user.getAddress());
        editor.putString(KEY_PROFIL_PIC, user.getProfil_pic());
        editor.putString(KEY_PHONE_NUM, user.getPhone_num());

        editor.commit();
    }

    public String getUserNpm(){
        return sharedPreferences.getString(PREFERENCE_NPM_LOGIN,null);
    }

    public User getUserLogin(){
        String name, npm, mail, password, json_address, address, profil_pic, phone_num;

        name = sharedPreferences.getString(KEY_NAME, "");
        npm = sharedPreferences.getString(KEY_NPM, "");
        mail = sharedPreferences.getString(KEY_MAIL, "");
        password = sharedPreferences.getString(KEY_PASSWORD, "");
        json_address = sharedPreferences.getString(KEY_JSON_ADDRESS,"");
        address = sharedPreferences.getString(KEY_ADDRESS,"");
        profil_pic = sharedPreferences.getString(KEY_PROFIL_PIC,"");
        phone_num = sharedPreferences.getString(KEY_PHONE_NUM,"");

        return new User(name, mail, npm, password, json_address, address, profil_pic, phone_num);
    }

    public boolean checkLogin(){
        return sharedPreferences.getBoolean(IS_LOGIN, false);
    }

    public void logout(){
        editor.remove(IS_LOGIN);
        editor.commit();
    }
}
