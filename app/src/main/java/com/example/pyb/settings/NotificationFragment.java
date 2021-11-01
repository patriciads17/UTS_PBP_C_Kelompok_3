package com.example.pyb.settings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.pyb.R;
import com.example.pyb.database.NotificationPreferences;

public class NotificationFragment extends Fragment {
    ImageView switchNotifAssignment, switchNotifAnnouncement, switchNotifGrade;
    Button btnSave;
    Boolean stateNotifAssignment = false;
    Boolean stateNotifAnnouncement = false;
    Boolean stateNotifGrade = false;
    NotificationPreferences notificationPreferences;

    public NotificationFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notification, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if(getActivity() != null){
            notificationPreferences = new NotificationPreferences(requireContext());
        }
        switchNotifAssignment = view.findViewById(R.id.switch_notif_assignment);
        switchNotifAnnouncement = view.findViewById(R.id.switch_notif_announcement);
        switchNotifGrade = view.findViewById(R.id.switch_notif_grade);
        btnSave = view.findViewById(R.id.button_save_notif);

        getNotificationState();
        setListener();
    }

    private void setListener(){
        switchNotifAssignment.setOnClickListener(view -> changeNotifAssignment(!stateNotifAssignment));
        switchNotifAnnouncement.setOnClickListener(view -> changeNotifAnnouncement(!stateNotifAnnouncement));
        switchNotifGrade.setOnClickListener(view -> changeNotifGrade(!stateNotifGrade));
        btnSave.setOnClickListener(view -> saveNotif());
    }

    private void getNotificationState(){
        if(notificationPreferences != null){
            changeNotifAssignment(notificationPreferences.getNotifAssignment());
            changeNotifAnnouncement(notificationPreferences.getNotifAnnouncement());
            changeNotifGrade(notificationPreferences.getNotifGrade());
        }
    }

    private void changeNotifAssignment(Boolean state){
        stateNotifAssignment = state;
        if(state){
            switchNotifAssignment.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.switch_on_logo, null));
        } else {
            switchNotifAssignment.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.switch_off_logo, null));
        }
    }

    private void changeNotifAnnouncement(Boolean state){
        stateNotifAnnouncement = state;
        if(state){
            switchNotifAnnouncement.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.switch_on_logo, null));
        } else {
            switchNotifAnnouncement.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.switch_off_logo, null));
        }
    }

    private void changeNotifGrade(Boolean state){
        stateNotifGrade = state;
        if(state){
            switchNotifGrade.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.switch_on_logo, null));
        } else {
            switchNotifGrade.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.switch_off_logo, null));
        }
    }

    private void saveNotif(){
        if(notificationPreferences != null){
            notificationPreferences.setNotifSetting(stateNotifAssignment, stateNotifAnnouncement, stateNotifGrade);
            SettingsFragment fragment = new SettingsFragment();
            FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frame_setting, fragment);
            fragmentTransaction.commit();
        }
    }
}