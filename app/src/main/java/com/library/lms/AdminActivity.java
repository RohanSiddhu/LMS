package com.library.lms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.library.lms.DB.AppDatabase;
import com.library.lms.DB.BooksDao;

import java.util.Locale;

public class AdminActivity extends AppCompatActivity {
    String LOG_TAG = "AdminActivity";

    // Views
    Button buttonBooks;
    Button buttonUsers;
    Button buttonHistory;
    Button buttonNotification;

    // Database
    DBhelper dBhelper;
    AppDatabase lmsDb;
    BooksDao booksDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        // Set Toolbar
        Toolbar toolbar = findViewById(R.id.toolbarHome);
        setSupportActionBar(toolbar);

        // Database
        dBhelper = new DBhelper(this);
        lmsDb = AppDatabase.getInstance(this);
        booksDao = lmsDb.booksDao();

        // Getting view reference.
        buttonBooks = findViewById(R.id.button_books);
        buttonUsers = findViewById(R.id.button_users);
        buttonHistory = findViewById(R.id.button_history);
        buttonNotification = findViewById(R.id.button_notifications);

        setButtonListener();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_close) {
            finish();
        } else if (id == R.id.menu_logout) {
            Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setButtonListener() {
        buttonBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(LOG_TAG, "Books Clicked");

                Intent intent = new Intent(getApplicationContext(), AdminBooksActivity.class);

                startActivity(intent);
            }
        });

        buttonUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(getApplicationContext(), AdminUsersActivity.class);


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