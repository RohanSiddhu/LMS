package com.library.lms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    String LOG_TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void adminLogin(View view) {
        Log.i(LOG_TAG, "Admin Login");

        Intent intent = new Intent(this, AdminActivity.class);

        startActivity(intent);
        this.finish();
    }

    public void userLogin(View view) {
        Log.i(LOG_TAG, "User Login");
    }
}