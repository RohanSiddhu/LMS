package com.library.lms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import com.library.lms.Adapter.*;


public class BooksActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);

        listView = findViewById(R.id.listView_books);

        ArrayList<String> bookList = new ArrayList<>();

        bookList.add("Book Name");
        bookList.add("Book Name");
        bookList.add("Book Name");
        bookList.add("Book Name");
        bookList.add("Book Name");
        bookList.add("Book Name");

        BookAdapter adapter = new BookAdapter(this, bookList);

        listView.setAdapter(adapter);
    }
}