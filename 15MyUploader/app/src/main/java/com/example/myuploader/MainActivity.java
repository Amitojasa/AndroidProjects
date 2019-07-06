package com.example.myuploader;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressbar,progressbar2;
    Button start,stop,upload;
    int progress =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressbar=findViewById(R.id.progressBar);
        progressbar2=findViewById(R.id.progressBar2);

        start=findViewById(R.id.start);
        stop=findViewById(R.id.stop);
        upload=findViewById(R.id.upload);

        progressbar.setVisibility(View.GONE);
    }

    public void start(View view){
        progressbar.setVisibility(View.VISIBLE);
    }
    public void stop(View view){
        progressbar.setVisibility(View.GONE);
    }
    public void upload(View view){
        fakeProgress(progress);
    }

    public void fakeProgress(final int progress){

        progressbar2.setProgress(progress);

        Thread thread=new Thread(new Runnable(){
            public void run(){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                fakeProgress(progress+10);
            }
        });
        thread.start();

    }

}
