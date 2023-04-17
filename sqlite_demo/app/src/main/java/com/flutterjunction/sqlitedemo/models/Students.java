package com.flutterjunction.sqlitedemo.models;

public class Students {
    int id;
    String name,dept, joinDate;
    double gpa;

    public Students(int id, String name, String dept, String joinDate, double gpa) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.joinDate = joinDate;
        this.gpa = gpa;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDept() {
        return dept;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public double getGpa() {
        return gpa;
    }


}
