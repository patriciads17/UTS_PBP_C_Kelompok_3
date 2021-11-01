package com.example.pyb.object;

import com.example.pyb.model.Announcement;

import java.util.ArrayList;

public class AnnouncementList {

    public ArrayList<Announcement> listAnnouncement;

    public AnnouncementList()
    {
        listAnnouncement = new ArrayList();
        listAnnouncement.add(Announcement1);
        listAnnouncement.add(Announcement2);
        listAnnouncement.add(Announcement3);
        listAnnouncement.add(Announcement4);
        listAnnouncement.add(Announcement5);
        listAnnouncement.add(Announcement6);
        listAnnouncement.add(Announcement7);
        listAnnouncement.add(Announcement8);
        listAnnouncement.add(Announcement9);
    }

    public static final Announcement Announcement1 = new Announcement("Pemrograman Berbasis Platform", "Topik 4", "See your grade now!!");

    public static final Announcement Announcement2 = new Announcement("Pemrograman Web", "Topik 4", "See your grade now!!");

    public static final Announcement Announcement3 = new Announcement("Pemrograman Berbasis Platform", "Topik 4", "Due date is about 1 day");

    public static final Announcement Announcement4 = new Announcement("Kuliah Lapangan", "Topik 3", "See your grade now!!");

    public static final Announcement Announcement5 = new Announcement("Pemrograman Web", "Topik 4", "Due date is about 1 day!");

    public static final Announcement Announcement6= new Announcement("Kuliah Lapangan", "Topik 3", "Due date is about 1 day!");

    public static final Announcement Announcement7 = new Announcement("Pemrograman Berbasis Platform", "Topik 3", "See your grade now!!");

    public static final Announcement Announcement8 = new Announcement("Pemrograman Web", "Topik 3", "See your grade now!!");

    public static final Announcement Announcement9 = new Announcement("Administrasi Basis Data", "Topik 3", "See your grade now!!");

}
