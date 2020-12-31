package com.example.tresnot;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    private static final String DBname = "dbname";
    private static final String TBname = "tbname";


    DbHelper(Context context){
        super(context, DBname, null,30);
    }

    @Override
    public void onCreate(SQLiteDatabase dataDb) {
        String tbcreate= "create table " +TBname+ "(id integer primary key, placez text)";
        dataDb.execSQL(tbcreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase dataDb, int oldVersion, int newVersion) {

        dataDb.execSQL("drop table if exists "+TBname);
        onCreate(dataDb);

    }

}
