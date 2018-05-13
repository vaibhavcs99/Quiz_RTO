package com.example.rupalisonawane.quizrto;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Instructions extends AppCompatActivity {

    public static int score = 0;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        //Next Page
        Intent intent1 = getIntent();
        name = intent1.getStringExtra("key");     //Acquired data from Previous Activity(Enter Name).

        TextView textView = findViewById(R.id.tv2);
        textView.setText(String.valueOf(name));

        Button button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(), question1.class);
                startActivity(intent2);
                finish();
            }
        });


    }

    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), R.string.warn1, Toast.LENGTH_SHORT).show();
    }


}
