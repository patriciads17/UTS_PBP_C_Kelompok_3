package com.example.pyb.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pyb.R;
import com.example.pyb.databinding.ItemCourseInBinding;
import com.example.pyb.model.CourseIn;

import java.util.List;

public class ItemCourseInAdapter extends RecyclerView.Adapter<ItemCourseInAdapter.MyViewHolder> {
    private Context context;
    private List<CourseIn> listCourseIn;

    public ItemCourseInAdapter(Context context, List<CourseIn> listCourseIn) {
        this.context = context;
        this.listCourseIn = listCourseIn;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        ItemCourseInBinding itemCourseInBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_course_in, parent,false);
        return new MyViewHolder(itemCourseInBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final CourseIn courseIn = listCourseIn.get(position);
        holder.itemCourseInBinding.setCourseIn(courseIn);
    }

    @Override
    public int getItemCount() {
        return listCourseIn.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ItemCourseInBinding itemCourseInBinding;
        public MyViewHolder(ItemCourseInBinding itemCourseInBinding)
        {
            super(itemCourseInBinding.getRoot());
            this.itemCourseInBinding = itemCourseInBinding;
        }
    }
}
