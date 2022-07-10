package com.library.lms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class AdminActivity extends AppCompatActivity {
    String LOG_TAG = "AdminActivity";

    Button buttonBooks;
    Button buttonUsers;
    Button buttonHistory;
    Button buttonNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        buttonBooks = findViewById(R.id.button_books);
        buttonUsers = findViewById(R.id.button_users);
        buttonHistory = findViewById(R.id.button_history);
        buttonNotification = findViewById(R.id.button_notifications);

        setButtonListener();
    }

    private void setButtonListener() {
        buttonBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(LOG_TAG, "Books Clicked");

                Intent intent = new Intent(getApplicationContext(), BooksActivity.class);

                startActivity(intent);
            }
        });

        buttonUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(getApplicationContext(), UsersOptionActivity.class);


                startActivity(intent);
            }
        });

        buttonHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(LOG_TAG, "History Clicked");
            }
        });

        buttonNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(LOG_TAG, "Notification Clicked");
            }
        });
    }
}