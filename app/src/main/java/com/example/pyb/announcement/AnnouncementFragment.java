package com.example.pyb.announcement;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pyb.adapter.ItemAnnouncementAdapter;
import com.example.pyb.databinding.FragmentAnnouncementBinding;
import com.example.pyb.model.Announcement;
import com.example.pyb.object.AnnouncementList;

import java.util.ArrayList;

public class AnnouncementFragment extends Fragment {
    private FragmentAnnouncementBinding fragmentAnnouncementBinding;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Announcement> listAnnouncement;
    private ItemAnnouncementAdapter adapter;

    public AnnouncementFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        fragmentAnnouncementBinding = FragmentAnnouncementBinding.inflate(inflater, container, false);
        View view = fragmentAnnouncementBinding.getRoot();
        listAnnouncement = new AnnouncementList().listAnnouncement;
        recyclerView=fragmentAnnouncementBinding.rvAnnouncement;
        adapter=new ItemAnnouncementAdapter(getContext(), listAnnouncement);
        layoutManager=new LinearLayoutManager(AnnouncementFragment.this.getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        fragmentAnnouncementBinding=null;

    }
}
