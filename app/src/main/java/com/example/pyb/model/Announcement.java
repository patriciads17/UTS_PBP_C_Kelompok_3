package com.example.pyb.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Announcement {
    @PrimaryKey
    private String id;
    private String namaMK;
    private String namaTopik;
    private String isiContent;

    public Announcement(String namaMK, String namaTopik, String isiContent) {
        this.namaMK = namaMK;
        this.namaTopik = namaTopik;
        this.isiContent = isiContent;
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

    public String getNamaTopik() {
        return namaTopik;
    }

    public void setNamaTopik(String namaTopik) {
        this.namaTopik = namaTopik;
    }

    public String getIsiContent() {
        return isiContent;
    }

    public void setIsiContent(String isiContent) {
        this.isiContent = isiContent;
    }
}
