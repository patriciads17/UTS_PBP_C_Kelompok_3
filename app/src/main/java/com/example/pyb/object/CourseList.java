package com.example.pyb.object;

import com.example.pyb.model.Course;

import java.util.ArrayList;

public class CourseList {
    public ArrayList<Course> listCourse;

    public CourseList(){
        listCourse = new ArrayList();
        listCourse.add(PBP);
        listCourse.add(PW);
        listCourse.add(KWH);
        listCourse.add(ABD);
        listCourse.add(KL);
    }

    public static final Course PBP = new Course("Pemrograman Berbasis Platfrom", "Thomas Adi Purnomo, S.T., M.T.", "Jumat, Sesi 1-2", 4);

    public static final Course PW = new Course("Pemrograman Web", "Thomas Adi Purnomo, S.T., M.T.", "Rabu, Sesi 1", 3);

    public static final Course KWH = new Course("Kewirausahaan", "Herlina, S.Kom., M.Eng.", "Selasa, Sesi 2", 3);

    public static final Course ABD = new Course("Administrasi Basis Data", "Eduard Rusdianto, S.T., M.T.", "Kamis, Sesi 4", 2);

    public static final Course KL = new Course("Kuliah Lapangan", "Herlina, S.Kom., M.Eng.", "Rabu, Sesi 4", 2);
}
