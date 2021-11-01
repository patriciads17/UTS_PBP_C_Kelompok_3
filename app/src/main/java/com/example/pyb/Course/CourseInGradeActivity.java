package com.example.pyb.Course;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.pyb.R;

public class CourseInGradeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_in_grade);

        changeFragment(new CourseInFragment());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater = new MenuInflater(this);
        menuInflater.inflate(R.menu.course_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        if(item.getItemId() == R.id.menu_coursein)
        {
            changeFragment(new CourseInFragment());
        }
        else if(item.getItemId()==R.id.menu_coursegrade)
        {
            changeFragment(new CourseGradeFragment());
        }

        return super.onOptionsItemSelected(item);
    }

    public void changeFragment(Fragment fragment)
    {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.layout_fragment,fragment)
                .commit();
    }
}
