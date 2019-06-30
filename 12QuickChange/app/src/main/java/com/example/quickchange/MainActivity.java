package com.example.quickchange;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    RelativeLayout layout;
    RadioGroup rgroup;
//    RadioButton rb,rg,rr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout=findViewById(R.id.layout);
        rgroup=findViewById(R.id.rgroup);
        rgroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i){
                    case R.id.rbtnblue:
                        layout.setBackgroundColor(Color.parseColor("#74B9FF"));
                        break;
                    case R.id.rbtngreen:
                        layout.setBackgroundColor(Color.parseColor("#45CE30"));
                        break;
                    case R.id.rbtnred:
                        layout.setBackgroundColor(Color.parseColor("#FF3E4D"));
                        break;

                }
            }
        });
    }
}
