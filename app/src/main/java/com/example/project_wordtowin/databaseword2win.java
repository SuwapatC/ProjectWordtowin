package com.example.project_wordtowin;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class databaseword2win {
    wordtowinhelp wtowhelper;

    public databaseword2win(Context context) {
        wtowhelper = new wordtowinhelp(context);
    }
    public short insert(String name){
        SQLiteDatabase wdb = wtowhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(wordtowinhelp.NAME,name);
        return (short) wdb.insert(wordtowinhelp.TABLE_NAME,null,contentValues);
    }

}
