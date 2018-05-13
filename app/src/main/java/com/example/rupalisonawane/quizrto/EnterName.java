package com.example.rupalisonawane.quizrto;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EnterName extends AppCompatActivity {
    public static String nameFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_name);
//Hides Action Bar
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
//Edit Text
        final EditText editText = findViewById(R.id.edit_text);
        Button button = findViewById(R.id.button1);
//Button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText.getText().toString();
                nameFinal = name;

                Intent intent = new Intent(getApplicationContext(), Instructions.class);
                intent.putExtra("key", name);

                startActivity(intent);
                finish();
            }
        });
    }
}
