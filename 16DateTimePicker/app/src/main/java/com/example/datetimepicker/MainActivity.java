package com.example.datetimepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

//    TimePicker timePicker;
    DatePicker datePicker;
    TextView   textView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        timePicker = findViewById(R.id.timePicker);
        datePicker = findViewById(R.id.datePicker);
        textView  = findViewById(R.id.textView);

//        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
//            @Override
//            public void onTimeChanged(TimePicker timePicker, int hour, int minute) {
//                textView.setText("Hour : "+ hour+ "\nminutes: "+minute);
//            }
//        });

        Calendar calendar = Calendar.getInstance();
        datePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int year, int month, int day) {
                month+=1;
                textView.setText("You selected: "+day+"-"+month+"-"+year);
            }
        });


    }
}
