package com.example.project_wordtowin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Wprdtowin3 extends AppCompatActivity {
    Button btnlevel2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wprdtowin3);

        btnlevel2 = (Button) findViewById(R.id.btnl2);

        btnlevel2.setOnClickListener(v -> {
            Intent level2 = new Intent(getApplicationContext(),wordlevel2.class);
            startActivity(level2);
        });
    }
}