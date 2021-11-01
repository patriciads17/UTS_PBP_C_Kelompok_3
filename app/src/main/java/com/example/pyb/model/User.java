package com.example.pyb.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "user")
public class User implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "mail")
    private String mail;

    @ColumnInfo(name = "npm")
    private String npm;

    @ColumnInfo(name = "password")
    private String password;

    @ColumnInfo(name ="address")
    private String address;

    @ColumnInfo(name = "json_address")
    private String jsonAddress;

    @Ignore
    @ColumnInfo(name = "profil_pic")
    private String profil_pic;

    @ColumnInfo(name = "phone_num")
    private String phone_num;

    public User(String name, String mail, String npm, String password, String jsonAddress, String address, String profil_pic, String phone_num) {
        this.name = name;
        this.mail = mail;
        this.npm = npm;
        this.password = password;
        this.jsonAddress = jsonAddress;
        this.address = address;
        this.profil_pic = profil_pic;
        this.phone_num = phone_num;
    }

    public User(String npm){
        this.npm = npm;
    }

//    public User(String npm, String password) {
//        this.npm = npm;
//        this.password = password;
//    }

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    public String getProfil_pic() {
        return profil_pic;
    }

    public void setProfil_pic(String profil_pic) {
        this.profil_pic = profil_pic;
    }

    public int getId() { return id; }

    public void setId(int id) {this.id = id;}

    public String getName() { return name; }

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNpm() {
        return npm;
    }

    public void setNpm(String npm) {
        this.npm = npm;
    }

    public String getJsonAddress() {
        return jsonAddress;
    }

    public void setJsonAddress(String jsonAddress) {
        this.jsonAddress = jsonAddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}

