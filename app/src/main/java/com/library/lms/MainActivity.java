package com.library.lms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import com.library.lms.DB.AppDatabase;

public class MainActivity extends AppCompatActivity {
    public AppDatabase lmsDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBhelper db = new DBhelper(this);
        SQLiteDatabase g = db.getReadableDatabase();

        // Room Database.
        lmsDb = AppDatabase.getInstance(this);
    }

    public void action(View view) {
        Intent i = new Intent(getApplicationContext(), student.class);
        startActivity(i);
    }

    public void action1(View view) {
        Intent i = new Intent(getApplicationContext(), teacher.class);
        startActivity(i);
    }
}