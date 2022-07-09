package com.library.lms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    String LOG_TAG = "MainActivity";
    Button userlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userlogin=findViewById(R.id.button_user);
        userlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Useractivity.class);
                startActivity(intent);
            }
        });
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