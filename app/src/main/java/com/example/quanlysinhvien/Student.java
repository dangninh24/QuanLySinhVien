package com.example.quanlysinhvien;

public class Student {
    private String name;
    private String id;
    private String class_name;
    private int img;

    public Student(String name, String id, String class_name, int img) {
        this.name = name;
        this.id = id;
        this.class_name = class_name;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
