package com.example.sqlitestudentrecord;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDB;

    EditText editTextid,editName,editEmail,editCC;
    Button buttonAdd,buttonGetData,buttonUpdate,buttonDelete, buttonViewAll;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDB = new DatabaseHelper(this);
        editTextid= findViewById(R.id.editText_id);
        editName= findViewById(R.id.editText_name);
        editEmail= findViewById(R.id.editText_email);
        editCC= findViewById(R.id.editText_CC);

        buttonAdd= findViewById(R.id.button_add);
        buttonDelete= findViewById(R.id.button_delete);
        buttonUpdate= findViewById(R.id.button_update);
        buttonGetData= findViewById(R.id.button_view);
        buttonViewAll= findViewById(R.id.button_viewAll);

        showMessage("test","Testing done");

        AddData();
        GetData();
        ViewAll();
        UpdataData();
        DeleteData();

    }

    public void AddData(){
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean isInserted= myDB.insertData(editName.getText().toString(),editEmail.getText().toString(),editCC.getText().toString());

                if(isInserted==true){
                    Toast.makeText(MainActivity.this,"Data Inserted",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"Something went wrong",Toast.LENGTH_SHORT).show();
                }

                //or
                //String myEmail = editEmail.getText().toString();


            }
        });
    }

    public void GetData(){

        buttonGetData.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                String id = editTextid.getText().toString();

                if(id.equals(String.valueOf(""))){
                    editTextid.setError("Enter Id");
                    return;
                }

                Cursor cursor = myDB.getData(id);
                String data=null;

                if(cursor.moveToNext()){
                    data="ID: "+cursor.getString(0)+"\n"+
                            "Name: "+cursor.getString(1)+"\n"+
                            "Email: "+cursor.getString(2)+"\n"+
                            "Course Count: "+cursor.getString(3)+"\n";
                }

                showMessage("Data",data);

            }
        });

    }

    public void ViewAll(){

        buttonViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor=myDB.getAllData();
                StringBuffer data= new StringBuffer();

                if(cursor.getCount()==0){
                    showMessage("Error","Nothing found in DB");
                    return;
                }
                while(cursor.moveToNext()){
                        data.append("ID: "+cursor.getString(0)+"\n"+
                                "Name: "+cursor.getString(1)+"\n"+
                                "Email: "+cursor.getString(2)+"\n"+
                                "Course Count: "+cursor.getString(3)+"\n\n");
                }
                showMessage("All data",data.toString());
            }
        });

    }

    public void UpdataData(){
        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean isUpdate = myDB.updateData(editTextid.getText().toString(),editName.getText().toString(),editEmail.getText().toString(),editCC.getText().toString());

                if(isUpdate==true){
                    Toast.makeText(MainActivity.this,"Updated Successfully",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"Sorry",Toast.LENGTH_SHORT).show();
                }


            }
        });
    }

    public void DeleteData(){
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer deletedRow= myDB.deleteData(editTextid.getText().toString());
                if(deletedRow>0){
                    Toast.makeText(MainActivity.this,"Deleted",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"Sorry",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void showMessage(String title,String message){
        AlertDialog.Builder builder= new AlertDialog.Builder(this);

        builder.create();
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();


    }



}
