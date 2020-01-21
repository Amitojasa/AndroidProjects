package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
    }

    public void gamePlay(View view){
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        Button btn= (Button)view;
        String tag= btn.getTag().toString();
        intent.putExtra("playWith",tag);
        startActivity(intent);
    }
}
