package com.example.pyb.object;

import com.example.pyb.model.CourseGrade;

import java.util.ArrayList;

public class CourseGradeList {
    public ArrayList<CourseGrade> listCourseGrade;

    public CourseGradeList()
    {
        listCourseGrade = new ArrayList();
        listCourseGrade.add(Grade1);
        listCourseGrade.add(Grade2);
        listCourseGrade.add(Grade3);
        listCourseGrade.add(Grade4);
        listCourseGrade.add(Grade5);
    }

    public static final CourseGrade Grade1 = new CourseGrade("Topik 1", "Modul 1", 100);

    public static final CourseGrade Grade2 = new CourseGrade("Topik 2", "Modul 2", 90);

    public static final CourseGrade Grade3 = new CourseGrade("Topik 3", "Modul 3", 100);

    public static final CourseGrade Grade4 = new CourseGrade("Topik 4", "Modul 4", 95);

    public static final CourseGrade Grade5 = new CourseGrade("Topik 5", "Modul 5", 80);


}
