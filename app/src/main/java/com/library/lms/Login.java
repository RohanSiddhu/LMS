package com.library.lms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        DBhelper db= new DBhelper(this);
        SQLiteDatabase g= db.getReadableDatabase();
    }
    public void action(View view) {
        Intent i = new Intent(getApplicationContext(),student.class);
        startActivity(i);
    }

    public void action1(View view) {
        Intent i = new Intent(getApplicationContext(),teacher.class);
        startActivity(i);
    }


}