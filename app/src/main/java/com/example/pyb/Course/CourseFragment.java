package com.example.pyb.Course;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pyb.adapter.ItemCourseAdapter;
import com.example.pyb.databinding.FragmentCourseBinding;
import com.example.pyb.model.Course;
import com.example.pyb.object.CourseList;

import java.util.ArrayList;

public class CourseFragment extends Fragment {
    private FragmentCourseBinding fragmentCourseBinding;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ItemCourseAdapter itemCourseAdapter;
    private ArrayList<Course> listCourse;

    public CourseFragment()
    {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        fragmentCourseBinding = FragmentCourseBinding.inflate(inflater, container, false);
        View view = fragmentCourseBinding.getRoot();
        listCourse=new CourseList().listCourse;

        recyclerView=fragmentCourseBinding.rvItemCourse;
        itemCourseAdapter=new ItemCourseAdapter(getContext(), listCourse);
        layoutManager=new LinearLayoutManager(CourseFragment.this.getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(itemCourseAdapter);

        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), CourseInGradeActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        fragmentCourseBinding=null;
    }

    public View.OnClickListener startIntent = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(CourseFragment.this.getContext(), CourseInGradeActivity.class );
            startActivity(intent);
        }
    };

}
