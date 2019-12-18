package com.example.json;

import com.google.gson.annotations.SerializedName;

public class Student {

    private String name;
    private String email;
    @SerializedName("courseCount")
    private int course_count;

    public Student(String name, String email, int courseCount) {
        this.name = name;
        this.email = email;
        this.course_count = courseCount;
    }
}
