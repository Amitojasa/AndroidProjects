package com.example.fireuserregister;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {


    // Write a message to the database
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    DatabaseReference userRef = myRef.child("Users");
    EditText userName,name,eMail;
    Button button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = findViewById(R.id.username);
        name = findViewById(R.id.name);
        eMail = findViewById(R.id.email);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String myUserName= userName.getText().toString().trim();
                String myName= name.getText().toString().trim();
                String myEmail= eMail.getText().toString().trim();

                HashMap<String,String> userMap = new HashMap<String,String>();
                userMap.put("UserName",myUserName);
                userMap.put("Name",myName);
                userMap.put("Email",myEmail);

                userRef.push().setValue(userMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(MainActivity.this,"Success",Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });

    }
}
