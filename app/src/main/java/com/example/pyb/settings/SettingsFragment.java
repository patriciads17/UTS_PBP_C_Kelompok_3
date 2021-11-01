package com.example.pyb.settings;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.pyb.R;
import com.example.pyb.database.UserPreferences;
import com.example.pyb.login.LoginActivity;

public class SettingsFragment extends Fragment {
    TextView tvPersonalInformation, tvPassword, tvNotif, tvAboutUs, tvHelp, tvLogout;
    private UserPreferences userPreferences;

    public SettingsFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(getActivity() != null){
            userPreferences = new UserPreferences(requireContext());
        }
        tvPersonalInformation = view.findViewById(R.id.text_view_personal_information);
        tvPassword = view.findViewById(R.id.text_view_password);
        tvNotif = view.findViewById(R.id.text_view_notification);
        tvAboutUs = view.findViewById(R.id.text_view_about);
        tvHelp = view.findViewById(R.id.text_view_helpcenter);
        tvLogout = view.findViewById(R.id.text_view_logout);

        setListener();
    }

    private void setListener(){
        tvNotif.setOnClickListener(view -> moveToNotifFragment());
        tvLogout.setOnClickListener(view -> doLogout());
    }

    private void doLogout(){
        if(userPreferences != null){
            userPreferences.logout();
            Intent moveToLogin = new Intent(requireContext(), LoginActivity.class);
            moveToLogin.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            moveToLogin.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            requireContext().startActivity(moveToLogin);
            requireActivity().finish();
        }
    }

    private void moveToNotifFragment(){
        NotificationFragment fragment = new NotificationFragment();
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_setting, fragment);
        fragmentTransaction.commit();
    }
}