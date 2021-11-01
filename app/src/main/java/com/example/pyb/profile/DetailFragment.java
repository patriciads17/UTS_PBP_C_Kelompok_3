package com.example.pyb.profile;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pyb.R;
import com.example.pyb.database.UserPreferences;
import com.example.pyb.model.User;

public class DetailFragment extends Fragment {

    private TextView tv1,tv2,tv3,tv4,tv5,tv6;
    private UserPreferences userPreferences;
    private User dataUser;

    public DetailFragment() {

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        userPreferences = new UserPreferences(getActivity());
        dataUser = userPreferences.getUserLogin();
        tv1.setText(dataUser.getName());
        tv2.setText(dataUser.getMail());
        if(!dataUser.getAddress().equals("")){
            tv3.setText(dataUser.getAddress());
        }else{
            tv3.setText("Jakarta,Indonesia");
        }

        if(!dataUser.getPhone_num().equals("")){
            tv4.setText(dataUser.getPhone_num());
        }else{
            tv4.setText("082292208002");
        }

        if(!dataUser.getAddress().equals("")){
            tv5.setText(dataUser.getAddress());
        }else{
            tv5.setText("Jl. Maju Bersama");
        }

        if(!dataUser.getJsonAddress().equals("")){
            tv6.setText(dataUser.getJsonAddress());
        }else{
            tv6.setText("Makassar,Indonesia");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        tv1 = view.findViewById(R.id.tvstudent_name);
        tv2 = view.findViewById(R.id.tvstudent_email);
        tv3 = view.findViewById(R.id.tvstudent_location);
        tv4 = view.findViewById(R.id.tvpersonal_dataisi1);
        tv5 = view.findViewById(R.id.tvpersonal_dataisi2);
        tv6 = view.findViewById(R.id.tvpersonal_dataisi3);
        return view;
    }
}