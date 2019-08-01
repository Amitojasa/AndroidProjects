package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.Formatter;

public class MainActivity extends AppCompatActivity {

    Button euro,pound,dollar,yen, dinar,btc,ausdollar,candollar,rubel;
    TextView textView;
    EditText editText;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        euro = findViewById(R.id.euro);
        pound = findViewById(R.id.pound);
        dollar = findViewById(R.id.dollar);
        yen = findViewById(R.id.yen);
        dinar = findViewById(R.id.dinar);
        ausdollar = findViewById(R.id.ausdollar);
        btc = findViewById(R.id.btc);
        candollar = findViewById(R.id.candollar);
        rubel = findViewById(R.id.rubel);
        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText2);


        euro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String z=editText.getText().toString();

                if(TextUtils.isEmpty(z)){
                    editText.setError("Empty User Input");
                }else{

                    double n,k;
                    n=Double.parseDouble(z);
                    textView.setText(null);
                    Formatter formatter = new Formatter();
                    k=n*0.012;
                    DecimalFormat numberFormat=new DecimalFormat("#.00");
                    textView.setText(""+numberFormat.format(k));
//                    textView.setText(""+k);
                }
            }
        });
        dollar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String z=editText.getText().toString();

                        if(TextUtils.isEmpty(z)){
                            editText.setError("Empty User Input");
                        }else{

                            double n,k;
                            n=Double.parseDouble(z);
                            textView.setText(null);
                            Formatter formatter = new Formatter();
                            k=n*0.012;
                            DecimalFormat numberFormat=new DecimalFormat("#.00");
                            textView.setText(""+numberFormat.format(k));
        //                    textView.setText(""+k);
                        }
                    }
                });


    }
}
