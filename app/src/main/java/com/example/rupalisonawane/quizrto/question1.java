package com.example.rupalisonawane.quizrto;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class question1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question1);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        RadioGroup radioGroup = findViewById(R.id.radiogrp);

        radioGroup.clearCheck();
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), R.string.warn1, Toast.LENGTH_SHORT).show();
    }

    //Move to next page

    public void nextPage(View view) {
        Intent intent3 = new Intent(getApplicationContext(), question2.class);
        startActivity(intent3);
        finish();
    }

    public void falseAll() {
        // Makes all options false
        RadioButton rb1 = findViewById(R.id.rd1);
        RadioButton rb2 = findViewById(R.id.rd2);
        RadioButton rb3 = findViewById(R.id.rd3);

        rb1.setEnabled(false);
        rb2.setEnabled(false);
        rb3.setEnabled(false);

    }

    public void onClickAnswer(View view) { //When Option is Selected
        RadioButton rb1 = findViewById(R.id.rd1);
        RadioButton rb2 = findViewById(R.id.rd2);
        RadioButton rb3 = findViewById(R.id.rd3);

        ImageView iv1 = findViewById(R.id.correct_answer);
        ImageView iv2 = findViewById(R.id.incorrect_answer);

        iv1.setVisibility(View.INVISIBLE);
        iv2.setVisibility(View.INVISIBLE);

        switch (view.getId()) {

            case R.id.rd1:
                iv2.setVisibility(View.VISIBLE);
                rb1.setTextColor(Color.RED);
                rb2.setTextColor(Color.parseColor("#558B2F"));
                Toast.makeText(getApplicationContext(), "Incorrect Answer", Toast.LENGTH_SHORT).show();
                falseAll();
                break;

            case R.id.rd2://Correct Answer
                iv1.setVisibility(View.VISIBLE);
                rb2.setTextColor(Color.parseColor("#558B2F"));
                Toast.makeText(getApplicationContext(), "Correct Answer", Toast.LENGTH_SHORT).show();
                falseAll();
                Instructions.score = Instructions.score + 1;
                break;

            case R.id.rd3:
                iv2.setVisibility(View.VISIBLE);
                rb3.setTextColor(Color.RED);
                rb1.setTextColor(Color.parseColor("#558B2F"));//Highlights
                falseAll();
                Toast.makeText(getApplicationContext(), "Incorrect Answer", Toast.LENGTH_SHORT).show();
                break;

        }
    }
}
