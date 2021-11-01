package com.example.pyb.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pyb.R;
import com.example.pyb.databinding.ItemAnnouncementBinding;
import com.example.pyb.model.Announcement;

import java.util.List;

public class ItemAnnouncementAdapter extends RecyclerView.Adapter<ItemAnnouncementAdapter.MyViewHolder> {
    private Context context;
    private List<Announcement> listAnnouncement;

    public ItemAnnouncementAdapter(Context context, List<Announcement> listAnnouncement) {
        this.context = context;
        this.listAnnouncement = listAnnouncement;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        ItemAnnouncementBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_announcement,parent, false);

        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Announcement announcement = listAnnouncement.get(position);
        holder.binding.setAnnouncement(announcement);
    }

    @Override
    public int getItemCount() {
        return listAnnouncement.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ItemAnnouncementBinding binding;
        public MyViewHolder(@NonNull ItemAnnouncementBinding binding)
        {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
