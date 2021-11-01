package com.example.pyb;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.pyb.Course.CourseFragment;
import com.example.pyb.announcement.AnnouncementFragment;
import com.example.pyb.database.UserPreferences;
import com.example.pyb.login.LoginActivity;
import com.example.pyb.profile.MyProfileFragment;
import com.example.pyb.settings.SettingsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;


    private BottomNavigationView.OnNavigationItemSelectedListener navigation = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            if(item.getItemId() == R.id.navigation_home){
                changeFragment(new MyProfileFragment());
            }else if(item.getItemId() == R.id.navigation_course){
                changeFragment(new CourseFragment());
            }else if(item.getItemId() == R.id.navigation_announcement){
                changeFragment(new AnnouncementFragment());
            }else if(item.getItemId() == R.id.navigation_settings){
                changeFragment(new SettingsFragment());
            }
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigation);
        changeFragment(new MyProfileFragment());
    }

    public void changeFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.layout_fragment,fragment)
                .commit();
    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
////      BottomNavigationView navView = findViewById(R.id.nav_view);
//        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);
//        bottomNavigationView.setOnNavigationItemSelectedListener(navigation);
//
//        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//
//        changeFragment(new MyProfileFragment());
//
//        BottomNavigationView navView = findViewById(R.id.nav_view);
//        // Passing each menu ID as a set of Ids because each
//        // menu should be considered as top level destinations.
//        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.navigation_home, R.id.navigation_course, R.id.navigation_announcement, R.id.navigation_settings)
//                .build();
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//        NavigationUI.setupWithNavController(binding.navView, navController);
//
//        if (getSupportActionBar() != null) {
//            getSupportActionBar().hide();
//        }
//
//        UserPreferences userPreferences = new UserPreferences(this);
//        if(!userPreferences.checkLogin()){
//            startActivity(new Intent(this, LoginActivity.class));
//            finish();
//        }
//    }
//
//
//    private BottomNavigationView.OnNavigationItemSelectedListener navigation = new BottomNavigationView.OnNavigationItemSelectedListener() {
//        @Override
//        public boolean onNavigationItemSelected(MenuItem item) {
//            if(item.getItemId() == R.id.navigation_home){
//                changeFragment(new MyProfileFragment());
//            }else if(item.getItemId() == R.id.navigation_course){
//                changeFragment(new CourseFragment());
//            }else if(item.getItemId() == R.id.navigation_announcement){
//                changeFragment(new AnnouncementFragment());
//            }else if(item.getItemId() == R.id.navigation_settings){
//                changeFragment(new SettingsFragment());
//            }
//            return true;
//        }
//    };
//
//    public void changeFragment(Fragment fragment){
//        getSupportFragmentManager()
//                .beginTransaction()
//                .replace(R.id.nav_host_fragment_activity_main,fragment)
//                .commit();
//    }
//
//
//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//        return false;
//    }
}