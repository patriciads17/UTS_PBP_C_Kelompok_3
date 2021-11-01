package com.example.pyb.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pyb.R;
import com.example.pyb.databinding.ItemCourseGradeBinding;
import com.example.pyb.model.CourseGrade;

import java.util.List;

public class ItemCourseGradeAdapter extends RecyclerView.Adapter<ItemCourseGradeAdapter.MyViewHolder> {
    private Context context;
    private List<CourseGrade> listCourseGrade;

    public ItemCourseGradeAdapter(Context context, List<CourseGrade> listCourseGrade) {
        this.context = context;
        this.listCourseGrade = listCourseGrade;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        ItemCourseGradeBinding itemCourseGradeBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_course_grade, parent, false);
        return new MyViewHolder(itemCourseGradeBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final CourseGrade courseGrade = listCourseGrade.get(position);
        holder.itemCourseGradeBinding.setCourseGrade(courseGrade);

    }

    @Override
    public int getItemCount() {
        return listCourseGrade.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        ItemCourseGradeBinding itemCourseGradeBinding;
        public MyViewHolder(ItemCourseGradeBinding itemCourseGradeBinding)
        {
            super(itemCourseGradeBinding.getRoot());
            this.itemCourseGradeBinding = itemCourseGradeBinding;
        }
    }
}
