package com.example.pyb.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pyb.R;
import com.example.pyb.databinding.ItemCourseBinding;
import com.example.pyb.model.Course;

import java.util.List;

public class ItemCourseAdapter extends RecyclerView.Adapter<ItemCourseAdapter.MyViewHolder>{
    private Context context;
    private List<Course> listCourse;

    public ItemCourseAdapter(Context context, List<Course> listCourse) {
        this.context = context;
        this.listCourse = listCourse;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        ItemCourseBinding itemCourseBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_course, parent, false);
        return new MyViewHolder(itemCourseBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Course course = listCourse.get(position);
        holder.itemCourseBinding.setCourse(course);
    }

    @Override
    public int getItemCount()
    {
        return listCourse.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        ItemCourseBinding itemCourseBinding;
        CardView cardView;
        public MyViewHolder(@NonNull ItemCourseBinding itemCourseBinding)
        {
            super(itemCourseBinding.getRoot());
            this.itemCourseBinding=itemCourseBinding;
            cardView=itemCourseBinding.courseItem;
        }
    }

}
