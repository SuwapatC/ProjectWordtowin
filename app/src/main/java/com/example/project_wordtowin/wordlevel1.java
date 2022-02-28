package com.example.project_wordtowin;

import  androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class wordlevel1 extends AppCompatActivity {
    public List<String> suggestSource = new ArrayList<>();
    public GridViewAnswerAdapter answerAdapter;
    public GridViewSuggestAdapter suggestAdapter;

    public Button btnSubmit,btnnext;

    public GridView gridViewAnswer,gridViewSuggest;

    public ImageView imgViewQuestion;

    int n=0;

    int[] image_list={

            R.drawable.airplan,
            R.drawable.boat,
            R.drawable.van,
            R.drawable.bus,
            R.drawable.taxi,
            R.drawable.train,
            R.drawable.truck,
            R.drawable.bicycle,
            R.drawable.tracktor,
    };
    public char[] answer;
    String correct_answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wordlevel1);

        //Init View
        initView();
    }

    private void initView() {
        gridViewAnswer = (GridView)findViewById(R.id.Gridveiwanswer);
        gridViewSuggest = (GridView)findViewById(R.id.Gridveiwsugs);

        imgViewQuestion = (ImageView)findViewById(R.id.imageView7);

        //Add SetupList Here
        setupList();

        btnSubmit = (Button)findViewById(R.id.btnSubmit);
        btnnext = (Button)findViewById(R.id.buttonnext);


        btnSubmit.setOnClickListener(v -> {
            StringBuilder result = new StringBuilder();

            for (int i = 0;  i < textline.user_submit_answer.length; i++)
            result.append(String.valueOf(textline.user_submit_answer[i]));
             n++;
            if (result.toString().equals(correct_answer)) {
                Toast.makeText(getApplicationContext(), "correct ! This is " + result, Toast.LENGTH_SHORT).show();
                //Reset
                textline.count = 0;
                textline.user_submit_answer = new char[correct_answer.length()];

                //Set Adapter
                GridViewAnswerAdapter answerAdapter = new GridViewAnswerAdapter(setupNullList(), getApplicationContext());
                gridViewAnswer.setAdapter(answerAdapter);
                answerAdapter.notifyDataSetChanged();

                GridViewSuggestAdapter suggestAdapter = new GridViewSuggestAdapter(suggestSource, getApplicationContext(), wordlevel1.this);
                gridViewSuggest.setAdapter(suggestAdapter);
                suggestAdapter.notifyDataSetChanged();

                setupList();
            } else {
                Toast.makeText(wordlevel1.this, "Incorrect!!!", Toast.LENGTH_SHORT).show();
            }
            if(n == 9) {
                btnSubmit.setVisibility(View.INVISIBLE);
                btnnext.setVisibility(View.VISIBLE);
                imgViewQuestion.setVisibility(View.INVISIBLE);
                gridViewAnswer.setVisibility(View.INVISIBLE);
                gridViewSuggest.setVisibility(View.INVISIBLE);

            }
        });

        btnnext.setOnClickListener(v -> {
            Intent level2 = new Intent(getApplicationContext(), Wprdtowin3.class);
            startActivity(level2);
        });

    }

    private void setupList() {
        //Random logo
        Random random = new Random();
        int imageSelected = image_list[random.nextInt(image_list.length)];
        imgViewQuestion.setImageResource(imageSelected);

        correct_answer = getResources().getResourceName(imageSelected);
        correct_answer = correct_answer.substring(correct_answer.lastIndexOf("/")+1);

        answer = correct_answer.toCharArray();

        textline.user_submit_answer = new char[answer.length];

        //Add Answer character to List
        suggestSource.clear();
        for(char item:answer)
        {
            //Add logo name to list
            suggestSource.add(String.valueOf(item));
        }

        //Random add some character to list
        for(int i = answer.length;i<answer.length*2;i++)
            suggestSource.add(textline.alphabet_character[random.nextInt(textline.alphabet_character.length)]);

        //Sort random
        Collections.shuffle(suggestSource);

        //Set for GridView
        answerAdapter = new GridViewAnswerAdapter(setupNullList(),this);
        suggestAdapter = new GridViewSuggestAdapter(suggestSource,this,this);

        answerAdapter.notifyDataSetChanged();
        suggestAdapter.notifyDataSetChanged();

        gridViewSuggest.setAdapter(suggestAdapter);
        gridViewAnswer.setAdapter(answerAdapter);
    }
    private char[] setupNullList() {
        char[] result = new char[answer.length];
        for(int i=0;i<answer.length;i++)
            result[i]=' ';
        return result;

    }



}