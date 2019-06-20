package com.example.buttonpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void bluePressed(View view){
        Toast.makeText(this,"Blue Pressed", Toast.LENGTH_SHORT).show();
    }
    public void redPressed(View view){
        Toast.makeText(this,"Red Pressed", Toast.LENGTH_LONG).show();
    }
}
