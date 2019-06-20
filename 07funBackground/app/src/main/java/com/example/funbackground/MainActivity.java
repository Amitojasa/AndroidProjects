package com.example.funbackground;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout cl;
    private ImageButton btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cl=findViewById(R.id.layout);
        btn=findViewById(R.id.imageButton);

        btn.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){

                Random rand=new Random();

                int color= Color.argb(255,rand.nextInt(256),rand.nextInt(256),rand.nextInt(256));

                cl.setBackgroundColor(color);

            }

        });
    }
}
