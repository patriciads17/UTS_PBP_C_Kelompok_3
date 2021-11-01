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
import com.example.pyb.adapter.ItemCourseInAdapter;
import com.example.pyb.databinding.FragmentCourseInBinding;
import com.example.pyb.model.CourseIn;
import com.example.pyb.object.CourseInList;

import java.util.ArrayList;

public class CourseInFragment extends Fragment {

    private FragmentCourseInBinding fragmentCourseInBinding;
    private RecyclerView recyclerView;
    private ArrayList<CourseIn> listCourseIn;
    private RecyclerView.LayoutManager layoutManager;
    private ItemCourseInAdapter itemCourseInAdapter;



    public CourseInFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        fragmentCourseInBinding = FragmentCourseInBinding.inflate(inflater, container, false);
        View view = fragmentCourseInBinding.getRoot();

        listCourseIn = new CourseInList().listCourseIn;

        recyclerView = fragmentCourseInBinding.rvItemCourseIn;
        itemCourseInAdapter = new ItemCourseInAdapter(getContext(), listCourseIn);
        layoutManager = new LinearLayoutManager(CourseInFragment.this.getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(itemCourseInAdapter);
        return view;
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        fragmentCourseInBinding = null;
    }
}
