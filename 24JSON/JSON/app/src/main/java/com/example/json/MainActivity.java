package com.example.json;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Gson gson = new Gson();

//        Student stu= new Student("Amitoj","amitoj@gmail.com",4);
//
//        String json = gson.toJson(stu);
//        String json="{\"courseCount\":4,\"email\":\"amitoj@gmail.com\",\"name\":\"Amitoj\"}";
//
//        Student student= gson.fromJson(json,Student.class);
//        Log.d("Test",student.toString());

        List<Video> videos= new ArrayList<>();
        videos.add(new Video("Intro",4));
        videos.add(new Video("Exercise",8));
        videos.add(new Video("End",12));

        Course course = new Course("Java","Bootcamp");

        Student student = new Student("Amitoj","as@gmail.com",3,course,videos);

        String json = gson.toJson(student);
        Log.d("test",json);
//          String json="{\"courseCount\":3,\"email\":\"as@gmail.com\",\"course\":{\"description\":\"Bootcamp\",\"name\":\"Java\"},\"name\":\"Amitoj\"}";
//          Student student = gson.fromJson(json,Student.class);


//          Log.d("test",student.toString());



    }
}
