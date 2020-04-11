package com.gm.bean;

/**
 * 2020/4/11 18:50
 */
public class Student {
    private int uid;
    private String stuName;

    public Student() {
    }

    public Student(int uid, String stuName) {
        this.uid = uid;
        this.stuName = stuName;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "uid=" + uid +
                ", stuName='" + stuName + '\'' +
                '}';
    }
}
