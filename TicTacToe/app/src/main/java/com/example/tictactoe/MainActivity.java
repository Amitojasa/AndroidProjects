package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean gameActive= true;

    //0-o
    //1-X
    //2-null
    int tag;
    int activePlayer=0;

    int[] gameState={2, 2, 2, 2, 2, 2, 2, 2, 2};
    View[] ids;
    int[][] winningPositions={   {0,1,2}, {3,4,5}, {6,7,8},
                                {0,3,6}, {1,4,7}, {2,5,8},
                                {0,4,8},{2,4,6}
                            };

    int count= gameState.length;
    TextView status,player1,player2,score;
    String winner;


    public void onTap(View view){
        ImageView img=(ImageView)view;
        int tappedImage= Integer.parseInt(img.getTag().toString());

        if(!gameActive){
            gameReset(view);
            return;
        }

        if(gameState[tappedImage]==2){
            count--;
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

            ///check win

            for(int[] winPosition : winningPositions){
                if(gameState[winPosition[0]]==gameState[winPosition[1]] && gameState[winPosition[1]]== gameState[winPosition[2]] && gameState[winPosition[0]]!=2){
                    if(gameState[winPosition[0]]==0 && gameActive){
                        winner="O has won";
                    }else{
                        winner="X has won";
                    }

                    gameActive=false;
                    status.setText(winner);

                }


            }

            if(count==0 && gameActive){
                gameActive=false;
                status.setText("Draw");
            }



        }else{
            //status.setText("Cant Update");
            Toast.makeText(MainActivity.this,"Cant update",Toast.LENGTH_SHORT).show();
        }

        if (tag == 1 && activePlayer == 1 && gameActive) {

            computerPlay();
        }
    }

    public void computerPlay(){

        View view=null;
        for(int i=0;i<9;i++){
            if(gameState[i]==2){
                 view= ids[i];
            }
        }
        if(view==null){
            status.setText("Error");
        }
        onTap(view);

    }

    public void gameReset(View view){
        gameActive=true;
        activePlayer=0;
        for(int i=0;i<gameState.length;i++){
            gameState[i]=2;
        }
        score.setText("0 - 0");

        count=gameState.length;

        ((ImageView)findViewById(R.id.c0)).setImageResource(0);
        ((ImageView)findViewById(R.id.c1)).setImageResource(0);
        ((ImageView)findViewById(R.id.c2)).setImageResource(0);
        ((ImageView)findViewById(R.id.c3)).setImageResource(0);
        ((ImageView)findViewById(R.id.c4)).setImageResource(0);
        ((ImageView)findViewById(R.id.c5)).setImageResource(0);
        ((ImageView)findViewById(R.id.c6)).setImageResource(0);
        ((ImageView)findViewById(R.id.c7)).setImageResource(0);
        ((ImageView)findViewById(R.id.c8)).setImageResource(0);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ids = new View[]{findViewById(R.id.c0), findViewById(R.id.c1), findViewById(R.id.c2), findViewById(R.id.c3), findViewById(R.id.c4), findViewById(R.id.c5), findViewById(R.id.c6), findViewById(R.id.c7), findViewById(R.id.c8)};
        status = findViewById(R.id.status);
        score = findViewById(R.id.score);
        player1 = findViewById(R.id.player1);
        player2 = findViewById(R.id.player2);


        Intent intent = getIntent();
        tag = Integer.parseInt(intent.getStringExtra("playWith"));

        if (tag == 1) {
            player1.setText("Player1");
            player2.setText("Computer");
        } else {
            player1.setText("Player1");
            player2.setText("Player2");
        }

        score.setText("0 - 0");


    }
}
