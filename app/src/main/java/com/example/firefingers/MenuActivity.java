package com.example.firefingers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MenuActivity extends AppCompatActivity {

    Button beginPlayButton,lessWinPoint,moreWinPrize;
     int winValue;
     TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        winValue = 5;
     //   lessWinPoint=findViewById(R.id.reduceButton);
        moreWinPrize=findViewById(R.id.incButton);
        beginPlayButton=findViewById(R.id.button2);
        textView=findViewById(R.id.textView);

        Button button = findViewById( R.id.reduceButton );



        moreWinPrize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                winValue++;
                textView.setText(Integer.toString(winValue));
            }
        });
        beginPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(getApplicationContext(),ArenaActivity.class);
                startActivity(intent1);
                finish();
            }
        });
    }
}
