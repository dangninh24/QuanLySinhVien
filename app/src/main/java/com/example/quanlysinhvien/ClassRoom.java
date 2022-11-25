package com.example.quanlysinhvien;

public class ClassRoom {
    private int img;
    private String class_id;
    private String class_name;
    private String teacher_name;

    public ClassRoom(int img, String class_id, String class_name, String teacher_name) {
        this.img = img;
        this.class_id = class_id;
        this.class_name = class_name;
        this.teacher_name = teacher_name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getClass_id() {
        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }
}
