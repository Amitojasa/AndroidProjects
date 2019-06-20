package com.example.diceassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView iv1,iv2;
    private Random r1= new Random();
    //private Random r2= new Random();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv1= findViewById(R.id.imageView);
        iv2= findViewById(R.id.imageView2);
    }

    public void rollIt(View view){
        int n1=r1.nextInt(6)+1;
        int n2=r1.nextInt(6)+1;

        switch (n2){
            case 1:
                iv2.setImageResource(R.drawable.dice1);
                break;
            case 2:
                iv2.setImageResource(R.drawable.dice2);
                break;
            case 3:
                iv2.setImageResource(R.drawable.dice3);
                break;
            case 4:
                iv2.setImageResource(R.drawable.dice4);
                break;
            case 5:
                iv2.setImageResource(R.drawable.dice5);
                break;
            case 6:
                iv2.setImageResource(R.drawable.dice6);
                break;

        }
        switch (n1){
            case 1:
                iv1.setImageResource(R.drawable.dice1);
                break;
            case 2:
                iv1.setImageResource(R.drawable.dice2);
                break;
            case 3:
                iv1.setImageResource(R.drawable.dice3);
                break;
            case 4:
                iv1.setImageResource(R.drawable.dice4);
                break;
            case 5:
                iv1.setImageResource(R.drawable.dice5);
                break;
            case 6:
                iv1.setImageResource(R.drawable.dice6);
                break;

        }
    }
}

