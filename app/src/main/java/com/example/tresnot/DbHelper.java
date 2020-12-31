package com.example.tresnot;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.core.content.ContextCompat;

import org.w3c.dom.Text;

import java.util.ArrayList;

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
    public boolean adding(String plc){
        SQLiteDatabase sqLiteDatabase= this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("places", plc);

        sqLiteDatabase.insert(TBname, null, contentValues);
        return true;

    }

    public ArrayList Viewing(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        ArrayList<String> arrayList = new ArrayList<String>();

        Cursor cursor = sqLiteDatabase.rawQuery("select * from "+TBname, null);
        cursor.moveToFirst();

        if(!cursor.isAfterLast()){
            arrayList.add(cursor.getString(cursor.getColumnIndex("plc")));
            cursor.moveToNext();
        }
        return arrayList;

    }

}
