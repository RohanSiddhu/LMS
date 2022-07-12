package com.library.lms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.library.lms.DB.AppDatabase;
import com.library.lms.DB.BooksDao;

import java.util.Locale;

public class AdminActivity extends AppCompatActivity {
    String LOG_TAG = "AdminActivity";

    Button buttonBooks;
    Button buttonUsers;
    Button buttonHistory;
    Button buttonNotification;
    TextView userCount;
    TextView bookCount;
    TextView issuedCount;

    DBhelper dBhelper;
    AppDatabase lmsDb;
    BooksDao booksDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        dBhelper = new DBhelper(this);
        lmsDb = AppDatabase.getInstance(this);
        booksDao = lmsDb.booksDao();

        buttonBooks = findViewById(R.id.button_books);
        buttonUsers = findViewById(R.id.button_users);
        buttonHistory = findViewById(R.id.button_history);
        buttonNotification = findViewById(R.id.button_notifications);
        userCount = findViewById(R.id.total_userCount);
        bookCount = findViewById(R.id.total_bookCount);
        issuedCount = findViewById(R.id.books_issueCount);

        setButtonListener();
        updateInfo();
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

    public void updateInfo() {
        // Total Users
        int totalUsers = dBhelper.getUserCount();
        userCount.setText(String.format(Locale.ENGLISH, "%d", totalUsers));

        // Total Books
        int totalBooks = booksDao.getSumTotal();
        bookCount.setText(String.format(Locale.ENGLISH, "%d", totalBooks));

        // Total Books Issued
        int booksIssued = totalBooks - booksDao.getSumAvailable();
        issuedCount.setText(String.format(Locale.ENGLISH, "%d", booksIssued));
    }
}