package com.example.project_wordtowin;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class wordtowinhelp extends SQLiteOpenHelper {
    static final String DB_NAME = "DBwtow";
    static final int DB_VERSION = 1;

    //table name
    public static final String TABLE_NAME="wordtowintable";

    //Table columns
    public static final String _ID="_id";
    public static final String NAME="name";

    //Creating table query
    private static final String CREATE_TABLE = "create table "+
            TABLE_NAME+"("+_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +NAME+" TEXT NOT NULL, "+" TEXT); ";

    public wordtowinhelp(Context context) {
        super(context,DB_NAME,null,DB_VERSION);
    }
    public void onCreate(SQLiteDatabase db){
        db.execSQL(CREATE_TABLE);

    }
    public void  onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }
}
