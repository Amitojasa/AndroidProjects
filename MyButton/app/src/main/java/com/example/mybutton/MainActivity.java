package com.example.mybutton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.myBtn);
//        sym = findViewById(R.id.simple);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("TEST","Clicked");
            }
        });
//        sym.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.d("TEST2","Clicked2");
//            }
//        });
    }
    public void bluePressed(View view){
//        Log.d("BLUE","clicked via method");
//        Context context=getApplicationContext();
//        CharSequence text ="hello from blue";
//        int duration = Toast.LENGTH_SHORT;
//        Toast toast = Toast.makeText(context,text,duration);
//        toast.show();
//        Toast.makeText(getApplicationContext(),"hello from blue",Toast.LENGTH_SHORT).show();
        Toast.makeText(this,"hello from blue",Toast.LENGTH_SHORT).show();
    }
}
