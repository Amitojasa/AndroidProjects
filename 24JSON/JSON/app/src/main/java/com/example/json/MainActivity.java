package com.example.json;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Gson gson = new Gson();

//        Student stu= new Student("Amitoj","amitoj@gmail.com",4);
//
//        String json = gson.toJson(stu);
        String json="{\"courseCount\":4,\"email\":\"amitoj@gmail.com\",\"name\":\"Amitoj\"}";

        Student student= gson.fromJson(json,Student.class);
        Log.d("Test",student.toString());
    }
}
