package com.example.project_wordtowin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Wprdtowin2 extends AppCompatActivity {
         Button btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wprdtowin2);

        btn2 = (Button) findViewById(R.id.btnl1);

        btn2.setOnClickListener(v -> {
            Intent level1 = new Intent(getApplicationContext(),wordlevel1.class);
            startActivity(level1);
        });
    }
}