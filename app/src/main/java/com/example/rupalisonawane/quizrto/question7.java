package com.example.rupalisonawane.quizrto;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class question7 extends AppCompatActivity {
    String finalAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question7);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), R.string.warn1, Toast.LENGTH_SHORT).show();
    }

    //Move to next page

    public void nextPage(View view) {
        Intent intent = new Intent(getApplicationContext(), question8.class);
        startActivity(intent);
        finish();
    }

    //Show answer
    public void onClickAnswer(View view) {
        String correctAnswer = "TRUE";

        ImageView iv1 = findViewById(R.id.correct_answer);
        ImageView iv2 = findViewById(R.id.incorrect_answer);
        Button button = findViewById(R.id.submit);

        iv1.setVisibility(View.INVISIBLE);
        iv2.setVisibility(View.INVISIBLE);

        EditText answer = findViewById(R.id.enterAnswer);
        finalAnswer = answer.getText().toString();
        finalAnswer = finalAnswer.toUpperCase();

        if (finalAnswer.equals(correctAnswer)) {
            Toast.makeText(getApplicationContext(), "Correct answer", Toast.LENGTH_SHORT).show();
            iv1.setVisibility(View.VISIBLE);
            Instructions.score = Instructions.score + 1;
            button.setEnabled(false);

        } else {
            Toast.makeText(getApplicationContext(), "Incorrect answer", Toast.LENGTH_SHORT).show();
            iv2.setVisibility(View.VISIBLE);
        }
    }
}
