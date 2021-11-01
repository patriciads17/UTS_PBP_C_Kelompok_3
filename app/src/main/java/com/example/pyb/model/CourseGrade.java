package com.example.pyb.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class CourseGrade {
    @PrimaryKey
    private String id;
    private String namaTopik;
    private String namaModul;
    private float nilaiModul;

    public CourseGrade(String namaTopik, String namaModul, float nilaiModul) {
        this.namaTopik = namaTopik;
        this.namaModul = namaModul;
        this.nilaiModul = nilaiModul;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamaTopik() {
        return namaTopik;
    }

    public void setNamaTopik(String namaTopik) {
        this.namaTopik = namaTopik;
    }

    public String getNamaModul() {
        return namaModul;
    }

    public void setNamaModul(String namaModul) {
        this.namaModul = namaModul;
    }

    public float getNilaiModul() {
        return nilaiModul;
    }

    public void setNilaiModul(float nilaiModul) {
        this.nilaiModul = nilaiModul;
    }
}
