package com.yunk.strikeballcounter;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.hanks.htextview.evaporate.EvaporateTextView;

import mehdi.sakout.fancybuttons.FancyButton;

public class MainActivity extends AppCompatActivity {
    EvaporateTextView strikeCount, ballCount, outCount;
    FancyButton getStrike, getBall,getFoul, getInPlay, getHit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View backgroundimage = findViewById(R.id.layout);
        Drawable background = backgroundimage.getBackground();
        background.setAlpha(90);

        strikeCount=findViewById(R.id.etv_strike);
        ballCount=findViewById(R.id.etv_ball);
        outCount=findViewById(R.id.etv_out);
        getStrike=findViewById(R.id.btn_strike);
        getBall=findViewById(R.id.btn_ball);
        getFoul=findViewById(R.id.btn_foul);
        getInPlay=findViewById(R.id.btn_inplay);
        getHit=findViewById(R.id.btn_hit);

        getStrike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Integer.parseInt(strikeCount.getText().toString())==2) { //strike out
                    strikeCount.animateText("0");
                    ballCount.animateText("0");
                    if (Integer.parseInt(outCount.getText().toString())<2) { //before 3 outs
                        int out = Integer.parseInt(outCount.getText().toString());
                        out++;
                        outCount.animateText(String.valueOf(out));
                    } else {
                        outCount.animateText("0");
                    }
                } else {
                    int strike = Integer.parseInt(strikeCount.getText().toString());
                    strike++;
                    strikeCount.animateText(String.valueOf(strike));
                }
            }
        });

        getBall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Integer.parseInt(ballCount.getText().toString())==3) { //walk
                    strikeCount.animateText("0");
                    ballCount.animateText("0");
                } else {
                    int ball = Integer.parseInt(ballCount.getText().toString());
                    ball++;
                    ballCount.animateText(String.valueOf(ball));
                }
            }
        });

        getFoul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Integer.parseInt(strikeCount.getText().toString())<2) {
                    int strike = Integer.parseInt(strikeCount.getText().toString());
                    strike++;
                    strikeCount.animateText(String.valueOf(strike));
                }
            }
        });

        getInPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Integer.parseInt(outCount.getText().toString())<2) { //before 3 outs
                    int out = Integer.parseInt(outCount.getText().toString());
                    out++;
                    outCount.animateText(String.valueOf(out));
                } else {
                    outCount.animateText("0");
                }
            }
        });

        getHit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strikeCount.animateText("0");
                ballCount.animateText("0");
            }
        });
    }
}
