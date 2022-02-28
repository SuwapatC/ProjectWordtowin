package com.example.project_wordtowin;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;

import java.util.List;


/**
 * Created by reale on 3/9/2017.
 */

public class GridViewSuggestAdapter extends BaseAdapter {

    private final List<String> suggestSource;
    private final Context context;
    private final wordlevel1 wordlevel1 ;

    public GridViewSuggestAdapter(List<String> suggestSource,
                                  Context context, wordlevel1 wordlevel1 ) {
        this.suggestSource = suggestSource;
        this.context = context;
        this.wordlevel1  = wordlevel1;
    }

    @Override
    public int getCount() {
        return suggestSource.size();
    }

    @Override
    public Object getItem(int position) {
        return suggestSource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Button button;
        if(convertView == null)
        {
            if(suggestSource.get(position).equals("null"))
            {
                button = new Button(context);
                button.setLayoutParams(new GridView.LayoutParams(120,120));
                button.setPadding(8,8,10,10);
                button.setBackgroundColor(Color.DKGRAY);
            }
            else
            {
                button = new Button(context);
                button.setLayoutParams(new GridView.LayoutParams(120,120));
                button.setPadding(8,8,10,10);
                //button.setBackgroundColor(Color.WHITE);
                button.setBackgroundResource(R.drawable.btnw);
                button.setTextColor(Color.DKGRAY);
                button.setText(suggestSource.get(position));
                button.setOnClickListener(v -> {
                    //If correct answer contains character user selected
                    if(String.valueOf(wordlevel1.answer).contains(suggestSource.get(position)))
                    {
                        char compare = suggestSource.get(position).charAt(0); // Get char

                        for(int i =0;i<wordlevel1.answer.length;i++)
                        {
                            if(compare == wordlevel1.answer[i])
                                textline.user_submit_answer[i] = compare;
                        }

                        //Update UI
                        GridViewAnswerAdapter answerAdapter = new GridViewAnswerAdapter(textline.user_submit_answer,context);
                        wordlevel1.gridViewAnswer.setAdapter(answerAdapter);
                        answerAdapter.notifyDataSetChanged();

                        //Remove from suggest source
                    }
                    else // else
                    {
                        //Remove from suggest source
                        wordlevel1.suggestSource.set(position,"null");
                        wordlevel1.suggestAdapter = new GridViewSuggestAdapter(wordlevel1.suggestSource,context,wordlevel1);
                        wordlevel1.gridViewSuggest.setAdapter(wordlevel1.suggestAdapter);
                        wordlevel1.suggestAdapter.notifyDataSetChanged();
                    }
                });
            }
        }
        else
            button = (Button)convertView;
        return button;

    }
}

