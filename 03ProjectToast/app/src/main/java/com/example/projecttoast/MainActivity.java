package com.example.projecttoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void redPressed(View view){

//        Toast.makeText(this,"red pressed",Toast.LENGTH_SHORT).show();
        showCustomToast("Customized Toast");
    }

    public void showCustomToast(String string){
        //get inflater

        LayoutInflater inflater= getLayoutInflater();
        View layout=inflater.inflate(R.layout.toast_layout,(ViewGroup)findViewById(R.id.toast_root));

        TextView toastText=layout.findViewById(R.id.toast_text);
        toastText.setText(string);

        Toast toast= new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER,0,0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();


    }

    public void bluePressed(View view){

        showAndroidCustomToast();

    }

    public void showAndroidCustomToast(){
        LayoutInflater inflater=getLayoutInflater();
        View layout2=inflater.inflate(R.layout.android_layout,(ViewGroup)findViewById(R.id.android_root));

        Toast toast=new Toast(getApplicationContext());
        toast.setGravity(Gravity.BOTTOM,0,0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout2);
        toast.show();



    }

}

