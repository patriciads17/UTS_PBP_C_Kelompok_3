package com.example.pyb.object;

import com.example.pyb.model.CourseIn;

import java.util.ArrayList;

public class CourseInList {
    public ArrayList<CourseIn> listCourseIn;

    public CourseInList()
    {
        listCourseIn = new ArrayList();
        listCourseIn.add(Topik1);
        listCourseIn.add(Topik2);
        listCourseIn.add(Topik3);
        listCourseIn.add(Topik4);
        listCourseIn.add(Topik5);
    }

    public static final CourseIn Topik1 = new CourseIn("Topik 1", "Modul 1", "Tugas 1");

    public static final CourseIn Topik2 = new CourseIn("Topik 2", "Modul 2", "Tugas 2");

    public static final CourseIn Topik3 = new CourseIn("Topik 3", "Modul 3", "Tugas 3");

    public static final CourseIn Topik4 = new CourseIn("Topik 4", "Modul 4", "Tugas 4");

    public static final CourseIn Topik5 = new CourseIn("Topik 5", "Modul 5", "Tugas 5");

}
