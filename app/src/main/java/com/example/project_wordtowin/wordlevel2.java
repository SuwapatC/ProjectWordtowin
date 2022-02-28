package com.example.project_wordtowin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class wordlevel2 extends AppCompatActivity {
    public List<String> suggestSource = new ArrayList<>();
    public GridViewAnswerAdapter answerAdapter;
    public GridViewSuggestAdapter suggestAdapter;

    public Button btnSubmit,btnnext;

    public GridView gridViewAnswer,gridViewSuggest;

    public ImageView imgViewQuestion;

    int n=0;

    int[] image_list={

            R.drawable.archery,
            R.drawable.fencer,
            R.drawable.football,
            R.drawable.boxing,
            R.drawable.volleyball,
            R.drawable.badminton,
            R.drawable.basketball,
            R.drawable.hockey,
            R.drawable.gymnastics,
    };
    public char[] answer;
    String correct_answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wordlevel2);
    }
}