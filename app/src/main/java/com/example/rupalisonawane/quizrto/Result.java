package com.example.rupalisonawane.quizrto;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Result extends AppCompatActivity {
    int finalScore;
    String finalName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        finalScore = Instructions.score;
        finalName = EnterName.nameFinal;

        TextView name = findViewById(R.id.name);
        name.setText(String.valueOf(finalName));

        TextView score = findViewById(R.id.score);
        score.setText(String.valueOf(finalScore));

        //score review
        TextView scoreReview = findViewById(R.id.scoreReview);
        if (finalScore >= 6) {
            scoreReview.setText("Excellent! You Passed the test");
        } else if (finalScore >= 4) {
            scoreReview.setText("Good! You passed the test");
        } else {
            scoreReview.setText("Let's Try Again");
        }
        Instructions.score = 0;
    }

    //Sends Your Marks
    public void share(View view) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "The Score of " + finalName + "is " + finalScore);
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }
}
