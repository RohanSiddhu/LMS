package com.library.lms;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelperStudent extends SQLiteOpenHelper {
    static  final String DATABASE_NAME="student.db";
    static  final String TABLE_NAME="student";
    static final String COL_1="ID";
    static final String COL_2="BOOKNAME";
    public DatabaseHelperStudent( Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_NAME+" (ID INTEGER PRIMARY KEY AUTOINCREMENT,BOOKNAME TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }
    public boolean getreq(String name){
        SQLiteDatabase database=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_2,name);
        long x=database.insert(TABLE_NAME,null,contentValues);
        if(x==-1){
            return false;
        }
        else{
            return  true;
        }
    }
    public Cursor showreq(){
        SQLiteDatabase database=this.getWritableDatabase();
        Cursor cursor=database.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        return  cursor;
    }
    public Integer reqdel(String id){
        SQLiteDatabase database=this.getWritableDatabase();
        return database.delete(TABLE_NAME,"ID=?",new String[]{id});
    }
}
