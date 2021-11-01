package com.example.pyb.profile;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.pyb.Course.CourseFragment;
import com.example.pyb.R;
import com.example.pyb.announcement.AnnouncementFragment;
import com.example.pyb.database.AppPreference;
import com.example.pyb.database.UserDatabase;
import com.example.pyb.database.UserPreferences;
import com.example.pyb.model.User;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyProfileFragment extends Fragment {

    private TextView tv1,tv2,tv3;
    private CircleImageView cv,btnEdit;
    private LinearLayout ll1,ll2,ll3;
    private UserPreferences userPreferences;
    private User dataUser;

    public MyProfileFragment() {
        // Required empty public constructor
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
//        getUserProfile();

        ll1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(new DetailFragment());
            }
        });

        ll2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(new CourseFragment());
            }
        });

        ll3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(new AnnouncementFragment());
            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditFragment editFragment = new EditFragment();
                Bundle profileData = new Bundle();
                profileData.putSerializable("user_profile", dataUser);
                editFragment.setArguments(profileData);
                getActivity().getSupportFragmentManager().beginTransaction().
                        replace(R.id.layout_fragment,editFragment).commit();
            }
        });
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_profile, container, false);
        tv1 = view.findViewById(R.id.tvstudent_name);
        tv2 = view.findViewById(R.id.tvstudent_email);
        tv3 = view.findViewById(R.id.tvstudent_location);
        cv = view.findViewById(R.id.profile_pic);
        btnEdit = view.findViewById(R.id.btnEdit);
        ll1 = view.findViewById(R.id.ll_detail);
        ll2 = view.findViewById(R.id.ll_grade);
        ll3 = view.findViewById(R.id.ll_reminder);
        return view;


    }

    private void getUserProfile() {
        class GetUserProfile extends AsyncTask<Void, Void, User> {

            @Override
            protected User doInBackground(Void... voids) {
                UserPreferences userPreferences = new UserPreferences(MyProfileFragment.this.getActivity().getApplicationContext());
                String npm = userPreferences.getUserNpm();

                if(npm != null){
                    dataUser = UserDatabase.getInstance(getActivity().getApplicationContext())
                            .getAppDatabase()
                            .userDao()
                            .getUserProfile(npm);
                    return dataUser;
                }

                return null;
            }

            @Override
            protected void onPostExecute(User user) {
                super.onPostExecute(user);
                if(user!=null) {
                    tv1.setText(user.getName());
                    tv2.setText(user.getMail());
                    tv3.setText(user.getAddress());
                    if(!user.getProfil_pic().equals("-")){
                        Glide.with(getContext())
                                .load(Uri.parse(user.getProfil_pic()))
                                .into(cv);
                    }else{
                        Glide.with(getContext())
                                .load(R.drawable.dream)
                                .into(cv);
                    }
                }
            }
        }

        GetUserProfile getProfile = new GetUserProfile();
        getProfile.execute();
    }

    public void changeFragment(Fragment fragment){
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.layout_fragment,fragment)
                .commit();
    }
}