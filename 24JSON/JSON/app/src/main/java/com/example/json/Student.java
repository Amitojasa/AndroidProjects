package com.example.json;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Student {

    private String name;
    private String email;
    @SerializedName("courseCount")
    private int course_count;

    @SerializedName("course")
    private Course mCourse;

    @SerializedName("video")
    private List<Video> mVideo;

    public Student(String name, String email, int courseCount, Course course, List<Video> video) {
        this.name = name;
        this.email = email;
        this.course_count = courseCount;
        this.mCourse = course;
        mVideo=video;
    }
}
