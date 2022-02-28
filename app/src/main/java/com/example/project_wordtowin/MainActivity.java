package com.example.project_wordtowin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText Name;
    Button bt1;
    databaseword2win admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = (EditText) findViewById(R.id.ETName);
        bt1 = (Button) findViewById(R.id.btnc);


        admin = new databaseword2win(this);

        bt1.setOnClickListener(v -> {
            addUser();
            Intent intent1 = new Intent(getApplicationContext(), Wprdtowin2.class);
            startActivity(intent1);
        });

    }



    public void addUser() {
        String t1 = Name.getText().toString();

        if (t1.isEmpty()) {
            Toast.makeText(this, "Enter name again", Toast.LENGTH_SHORT).show();
        } else {
            // add to database
            short id = admin.insert(t1);
        }

    }



}