package com.library.lms;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBhelper  extends SQLiteOpenHelper {
    public static final String database = "signUp.db";

    public DBhelper( Context context ) {
        super(context,database, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase Mydb) {
        String q ="create table users (id integer primary key autoincrement, name text, username text,email text, password text)";
        Mydb.execSQL(q);
    }

    @Override
    public void onUpgrade(SQLiteDatabase Mydb, int oldVersion, int newVersion) {

    }
    public boolean insertData(String name, String username,String email,String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues c = new ContentValues();
        c.put("name",name);
        c.put("username",username);
        c.put("email",email);
        c.put("password",password);
        long r = db.insert("users",null,c);
        if(r ==-1)
            return false;
        else
            return true;

    }


    public boolean  checkuser(String email ){
        SQLiteDatabase Mydb = this.getWritableDatabase();
        Cursor c =  Mydb.rawQuery("select * from users where email = ?", new String[]{email});
        if(c.getCount() > 0 )
            return true;
        else
            return false;
    }
    public boolean checkuserpass(String email, String pass){
        SQLiteDatabase Mydb = this.getWritableDatabase();
        Cursor c = Mydb.rawQuery("select * from users where email = ? and password =?",new String[] {email,pass});
        if(c.getCount() > 0 ){
            return  true;
        }
        else
            return false;
    }

    public Cursor getInfo(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c= db.rawQuery("select * from users",null);
        return c;
    }
    public boolean delete_data(String email){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("select * from users where email=?",new String[]{email});
        if(c.getCount()>0){

            long r = db.delete("users","email=?",new String[]{email});
            if(r == -1)
                return false;
            else
                return true;
        }
        else
            return false;
    }
    public int getUserCount(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c= db.rawQuery("select * from users",null);
        if(c.getCount()>0){
            return c.getCount();
        }
        else{
            return 0;
        }
    }
}

