package com.example.myintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);

    }

    public void screenOne(View view){

        String value=editText.getText().toString();

        if(value.length()==0){
            editText.setError("No Value");
        }else{
            Intent intent = new Intent(MainActivity.this,Main2Activity.class);
//
//            intent.putExtra("name",value);
//            intent.putExtra("password",value+" new");

              Bundle bundle = new Bundle();

              bundle.putString("name",value);
              bundle.putString("password",value+ " new");

              intent.putExtras(bundle);

            startActivity(intent);
        }




    }

}
