package com.yunk.stupidcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.hanks.htextview.evaporate.EvaporateTextView;
import com.hanks.htextview.line.LineTextView;

import mehdi.sakout.fancybuttons.FancyButton;

public class MainActivity extends AppCompatActivity {
    EvaporateTextView etv;
    FancyButton next, previous, toZero, goToNum;
    EditText goToCertainNum, step;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etv = findViewById(R.id.etv_1);
        etv.animateText("0");
        etv.animate();

        next=findViewById(R.id.btn_next);
        previous=findViewById(R.id.btn_previous);
        toZero=findViewById(R.id.btn_zero);
        goToNum=findViewById(R.id.btn_goto);
        goToCertainNum=findViewById(R.id.et_gotonum);
        step=findViewById(R.id.et_step);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentNum=Integer.parseInt(etv.getText().toString());
                currentNum+=Integer.parseInt(step.getText().toString());
                etv.animateText(String.valueOf(currentNum));
            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentNum=Integer.parseInt(etv.getText().toString());
                currentNum--;
                etv.animateText(String.valueOf(currentNum));
            }
        });

        toZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etv.animateText("0");
            }
        });

        goToNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etv.animateText(goToCertainNum.getText().toString());
            }
        });
    }
}
