package com.example.a22recyclercards;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ArrayList<ExampleItem> exampleList;

    private Button buttonAdd,buttonDelete;
    private EditText editTextAdd,editTextDelete;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateFakedata();
        recyclerViewConfigs();

        buttonAdd= findViewById(R.id.buttonadd);
        buttonDelete=findViewById(R.id.buttondelete);
        editTextAdd=findViewById(R.id.edittextadd);
        editTextDelete=findViewById(R.id.edittextdelete);


        buttonAdd.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                int pos=Integer.parseInt(editTextAdd.getText().toString());
                addCard(pos);
            }

        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos=Integer.parseInt(editTextDelete.getText().toString());
                removeCard(pos);
            }
        });


    }

    public void generateFakedata(){

        exampleList= new ArrayList<ExampleItem>();

        exampleList.add(new ExampleItem(R.drawable.node,"Clicked at Studio"));
        exampleList.add(new ExampleItem(R.drawable.oner,"Clicked at Italy"));
        exampleList.add(new ExampleItem(R.drawable.twor,"Clicked at Rome"));
        exampleList.add(new ExampleItem(R.drawable.threer,"Clicked at Greece"));
        exampleList.add(new ExampleItem(R.drawable.fourr,"Clicked at Rome"));
        exampleList.add(new ExampleItem(R.drawable.fiver,"Clicked at Switzerland"));
        exampleList.add(new ExampleItem(R.drawable.sixr,"Clicked at India"));
    }

    public void recyclerViewConfigs(){
        //Config for rv

        recyclerView=findViewById(R.id.recyclerView);
        //performance
        recyclerView.setHasFixedSize(true);

        layoutManager=new LinearLayoutManager(this);
        adapter= new ExampleAdapter(exampleList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }

    public void addCard(int pos){
        exampleList.add(pos,new ExampleItem(R.drawable.node,"New card added"));
        //adapter.notifyDataSetChanged();
        //or beeter is
        adapter.notifyItemInserted(pos);

    }

    public void removeCard(int pos){
        exampleList.remove(pos);
        adapter.notifyItemRemoved(pos);
    }

}
