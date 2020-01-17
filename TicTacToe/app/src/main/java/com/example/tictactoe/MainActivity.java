package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //0-o
    //1-X
    //2-null

    int activePlayer=0;

    int[] gameState={2, 2, 2, 2, 2, 2, 2, 2, 2};

    int[][] winningPositions={   {0,1,2}, {3,4,5}, {6,7,8},
                                {0,3,6}, {1,4,7}, {2,5,8},
                                {0,4,8},{2,4,6}
                            };
    TextView status;


    public void onTap(View view){
        ImageView img=(ImageView)view;
        int tappedImage= Integer.parseInt(img.getTag().toString());

        if(gameState[tappedImage]==2){
            gameState[tappedImage]=activePlayer;
            img.setTranslationY(-1000f);
            if(activePlayer==0){

                img.setImageResource(R.drawable.o);
                activePlayer=1;
                status.setText("Player X");
            }else{
                img.setImageResource(R.drawable.x);
                activePlayer=0;
                status.setText("Player O");
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }else{
            //status.setText("Cant Update");
            Toast.makeText(MainActivity.this,"Cant uppdate",Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        status= findViewById(R.id.status);
        status.setText("Player O");
    }
}
