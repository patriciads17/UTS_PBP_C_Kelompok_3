package com.example.pyb.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class CourseIn {
    @PrimaryKey
    private String id;
    private String namaTopik;
    private String namaModul;
    private String namaTugas;

    public CourseIn(String namaTopik, String namaModul, String namaTugas) {
        this.namaTopik = namaTopik;
        this.namaModul = namaModul;
        this.namaTugas = namaTugas;
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

    public String getNamaTugas() {
        return namaTugas;
    }

    public void setNamaTugas(String namaTugas) {
        this.namaTugas = namaTugas;
    }
}
