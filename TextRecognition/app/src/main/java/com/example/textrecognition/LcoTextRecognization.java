package com.example.textrecognition;

import android.app.Application;

import com.google.firebase.FirebaseApp;

public class LcoTextRecognization extends Application {

    public static final String RESULT_TEXT= "RESULT_TEXT";

    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseApp.initializeApp(this);
    }
}
