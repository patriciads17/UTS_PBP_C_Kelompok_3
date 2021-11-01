package com.example.pyb.Course;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pyb.R;
import com.example.pyb.adapter.ItemCourseGradeAdapter;
import com.example.pyb.databinding.FragmentCourseGradeBinding;
import com.example.pyb.model.Course;
import com.example.pyb.model.CourseGrade;
import com.example.pyb.object.CourseGradeList;

import java.util.ArrayList;

public class CourseGradeFragment extends Fragment {

    private FragmentCourseGradeBinding fragmentCourseGradeBinding;
    private RecyclerView recyclerView;
    private ArrayList<CourseGrade> listCourseGrade;
    private RecyclerView.LayoutManager layoutManager;
    private ItemCourseGradeAdapter itemCourseGradeAdapter;

    public CourseGradeFragment()
    {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        fragmentCourseGradeBinding = FragmentCourseGradeBinding.inflate(inflater, container, false);
        View view = fragmentCourseGradeBinding.getRoot();
        listCourseGrade = new CourseGradeList().listCourseGrade;

        recyclerView = fragmentCourseGradeBinding.rvItemCourseGrade;
        itemCourseGradeAdapter = new ItemCourseGradeAdapter(getContext(), listCourseGrade);
        layoutManager = new LinearLayoutManager(CourseGradeFragment.this.getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(itemCourseGradeAdapter);
        return view;
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        fragmentCourseGradeBinding = null;
    }


}
