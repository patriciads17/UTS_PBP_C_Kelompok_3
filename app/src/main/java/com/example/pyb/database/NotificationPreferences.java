package com.example.pyb.database;

import android.content.Context;
import android.content.SharedPreferences;

public class NotificationPreferences {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context context;

    /* Mendefinisikan Key */
    public static final String NOTIF_ASSIGNMENT = "notifAssignment";
    public static final String NOTIF_ANNOUNCEMENT = "notifAnnouncement";
    public static final String NOTIF_GRADE = "notifGrade";

    public NotificationPreferences(Context context) {
        this.context = context;

        sharedPreferences = context.getSharedPreferences("userPreferences", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void setNotifSetting(Boolean state1, Boolean state2, Boolean state3) {
        editor.putBoolean(NOTIF_ASSIGNMENT, state1);
        editor.putBoolean(NOTIF_ANNOUNCEMENT, state2);
        editor.putBoolean(NOTIF_GRADE, state3);
        editor.commit();
    }

    public Boolean getNotifAssignment() {
        return sharedPreferences.getBoolean(NOTIF_ASSIGNMENT, false);
    }

    public Boolean getNotifAnnouncement() {
        return sharedPreferences.getBoolean(NOTIF_ANNOUNCEMENT, false);
    }

    public Boolean getNotifGrade() {
        return sharedPreferences.getBoolean(NOTIF_GRADE, false);
    }
}
