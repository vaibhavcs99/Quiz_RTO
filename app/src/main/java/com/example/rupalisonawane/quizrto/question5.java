package com.example.rupalisonawane.quizrto;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;

import static com.example.rupalisonawane.quizrto.Instructions.score;

public class question5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question5);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

    }

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), R.string.warn1, Toast.LENGTH_SHORT).show();
    }

    //Move to next page

    public void nextPage(View view) {
        Intent intent = new Intent(getApplicationContext(), question6.class);
        startActivity(intent);
        finish();
    }

    public void falseAll() {
        // Makes all options false
        CheckBox check1 = findViewById(R.id.check1);
        CheckBox check2 = findViewById(R.id.check2);
        CheckBox check3 = findViewById(R.id.check3);

        check1.setEnabled(false);
        check2.setEnabled(false);
        check3.setEnabled(false);
    }

    public void onClickAnswer(View view) {
        //When Option is Selected
        CheckBox check1 = findViewById(R.id.check1);
        CheckBox check2 = findViewById(R.id.check2);
        CheckBox check3 = findViewById(R.id.check3);

        ImageView iv1 = findViewById(R.id.correct_answer);
        ImageView iv2 = findViewById(R.id.incorrect_answer);

        iv1.setVisibility(View.INVISIBLE);
        iv2.setVisibility(View.INVISIBLE);

        switch (view.getId()) {

            case R.id.check1://Correct answer
            {
                if ((check1.isChecked()) && (check3.isChecked())) {
                    iv1.setVisibility(View.VISIBLE);
                    check1.setTextColor(Color.parseColor("#558B2F"));
                    check3.setTextColor(Color.parseColor("#558B2F"));
                    Toast.makeText(getApplicationContext(), "Correct Answer", Toast.LENGTH_SHORT).show();
                    falseAll();
                    Instructions.score = Instructions.score + 1;
                    break;
                }
            }

            case R.id.check2://Incorrect answer
            {
                if (check2.isChecked()) {
                    iv2.setVisibility(View.VISIBLE);
                    check2.setTextColor(Color.RED);//Highlights
                    falseAll();
                    Toast.makeText(getApplicationContext(), "Incorrect Answer", Toast.LENGTH_SHORT).show();
                    break;
                }
            }

            case R.id.check3: //Correct Answer
            {
                if ((check1.isChecked()) && (check3.isChecked())) {
                    iv1.setVisibility(View.VISIBLE);
                    check1.setTextColor(Color.parseColor("#558B2F"));
                    check3.setTextColor(Color.parseColor("#558B2F"));
                    Toast.makeText(getApplicationContext(), "Correct Answer", Toast.LENGTH_SHORT).show();
                    falseAll();
                    Instructions.score = Instructions.score + 1;
                    break;
                }
            }

        }
    }
}

