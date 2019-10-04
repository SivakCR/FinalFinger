package com.example.firefingers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ArenaActivity extends AppCompatActivity {

    private Button redButton,blueButton,playButton;
    private ImageButton menuButton;
    private int redPoints,bluePoints;
    private boolean counter;
    private TextView redPointView,bluePointView,genDataDisplay;
    private RelativeLayout buttonLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arena);
        redPoints=0;bluePoints=0;counter=false;
        genDataDisplay=(TextView)findViewById(R.id.genInformation);
        playButton=(Button)findViewById(R.id.playButton);
        menuButton=(ImageButton)findViewById(R.id.menuButton);
        redButton=(Button)findViewById(R.id.redButton);
        blueButton=(Button)findViewById(R.id.blueButton);
        redPointView=(TextView)findViewById(R.id.redTeamScore);
        bluePointView=(TextView)findViewById(R.id.blueTeamScore);
        menuButton.setVisibility(View.GONE);
        buttonLayout=(RelativeLayout)findViewById(R.id.allButtonLayout);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playButton.setVisibility(View.GONE);
                buttonLayout.setVisibility(View.GONE);
                countDownBeginner();
            }
        });
        redButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.w("CountDown","Worling");
                if (counter){
                    counter=false;
                    redPoints++;
                    redPointView.setText(Integer.toString(redPoints));
                    countDownBeginner();
                    if(checkWin("Red",redPoints)){

                        // menuButton.setImageResource(R.drawable.my_image);   Here add win team png for red team
                        dead();
                    }
                    else
                        countDownBeginner();
                }
            }
        });

        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(getApplicationContext(),MenuActivity.class);
                startActivity(intent2);
                finish();
            }
        });
        blueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.w("CountDown","Worling");
                if (counter){
                    counter=false;
                    bluePoints++;
                    bluePointView.setText(Integer.toString(bluePoints));
                    if(checkWin("BLue",bluePoints)){
                        // menuButton.setImageResource(R.drawable.my_image);   Here add win team png for blue team
                        dead();
                    }
                    else
                        countDownBeginner();
                }
            }
        });
    }

    private void dead() {
            buttonLayout.setVisibility(View.VISIBLE);
            menuButton.setVisibility(View.VISIBLE);
    }

    private boolean checkWin(String teamName, int teamPoints) {
        if(teamPoints==5) {
            genDataDisplay.setText("Team "+teamName+" wins the battle!");
            return true;
        }
        return false;
    }
    void countDownBeginner(){
        new CountDownTimer(3000,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                Log.w("CountDown","Worling");
                genDataDisplay.setText("Countdown @"+(Long.toString(millisUntilFinished/1000)));
            }

            @Override
            public void onFinish() {
                counter=true;
            }
        }.start();
    }
}
