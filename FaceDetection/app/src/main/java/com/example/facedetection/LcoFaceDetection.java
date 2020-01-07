package com.example.facedetection;

import android.app.Application;

import androidx.annotation.NonNull;

import com.google.firebase.FirebaseApp;

public class LcoFaceDetection extends Application {

    public static final String RESULT_TEXT = "RESULT_TEXT";
    public static final String RESULT_DIALOG = "RESULT_DIALOG";

    @Override
    public void onCreate(){
        super.onCreate();
        FirebaseApp.initializeApp(this);
    }
}
