package com.example.pyb.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Course {
    @PrimaryKey
    private String id;
    private String namaMK;
    private String namaDosen;
    private String jadwalMK;
    private int jlhSks;

    public Course( String namaMK, String namaDosen, String jadwalMK, int jlhSks) {
        this.namaMK = namaMK;
        this.namaDosen = namaDosen;
        this.jadwalMK = jadwalMK;
        this.jlhSks = jlhSks;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamaMK() {
        return namaMK;
    }

    public void setNamaMK(String namaMK) {
        this.namaMK = namaMK;
    }

    public String getNamaDosen() {
        return namaDosen;
    }

    public void setNamaDosen(String namaDosen) {
        this.namaDosen = namaDosen;
    }

    public String getJadwalMK() {
        return jadwalMK;
    }

    public void setJadwalMK(String jadwalMK) {
        this.jadwalMK = jadwalMK;
    }

    public int getJlhSks() {
        return jlhSks;
    }

    public void setJlhSks(int jlhSks) {
        this.jlhSks = jlhSks;
    }

}

