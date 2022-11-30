package com.library.lms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.library.lms.Adapter.*;
import com.library.lms.DB.AppDatabase;
import com.library.lms.DB.Books;
import com.library.lms.DB.BooksDao;


public class AdminBooksActivity extends AppCompatActivity {
    ListView listView;
    ImageView searchButton;
    FloatingActionButton addButton;

    AppDatabase dbRoom;
    BooksDao booksDao;
    BookAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_books);

        // Get view reference
        listView = findViewById(R.id.listView_books);
        searchButton = findViewById(R.id.button_search);
        addButton = findViewById(R.id.floatingButton_books);

        // Init Database
        dbRoom = AppDatabase.getInstance(this);
        booksDao = dbRoom.booksDao();
        List<Books> books = booksDao.getAll();
        if (books.size() == 0) {
            booksDao.insertAll(
                    new Books(978_81_203_4007_7L, "Introduction To Algorithms", "Thomas H. Cormen, Charles E. Leiserson, Ronald L. Rivest, Clifford Stein", 5, 3),
                    new Books(978_81_265_5427_0L, "Operating System Concepts", "Abraham Silberschatz, Peter B Galvin, Greg Gagne", 7, 6),
                    new Books(978_93_87432_29_1L, "Java: The Complete Reference, Tenth Edition", "Herbert Schildt", 3, 2),
                    new Books(978_01_99459_63_6L, "Object Oriented Programming with C++", "Reema Thareja", 7, 3),
                    new Books(978_93_51109_05_1L, "Effective Modern C++", "Scott Meyers", 10, 7),
                    new Books(978_1_118_53164_8L, "JavaScript & JQuery: interactive front-end web development", "Jon Duckett", 25, 13),
                    new Books(978_81_265_7713_2L, "Principles of Soft Compution", "S.N. Sivanandam, S.N. Deepa", 5, 3),
                    new Books(978_81_317_2047_9L, "Introduction to Automata Theory, Languages, and Computation", "John E. Hopcroft, Rajeev Motwani, Jeffrey D. Ullman", 19, 15),
                    new Books(978_81_8487_560_7L, "Advanced Engineering Mathematics", "R.K. Jain", 31, 18),
                    new Books(978_81_219_2498_6L, "Quantitative Aptitude", "Dr. R.S. Aggarwal", 27, 19)
            );
            books = booksDao.getAll();
        }

        // Init ListView
        adapter = new BookAdapter(this, books);
        listView.setAdapter(adapter);

        setListeners();
    }

    private void setListeners() {
        // Search Button
        searchButton.setOnClickListener(view -> {
            Toast.makeText(getApplicationContext(), "Search Books", Toast.LENGTH_SHORT).show();
        });

        // Add button
        addButton.setOnClickListener(view -> {
            Intent intent = new Intent(AdminBooksActivity.this, AdminAddBookActivity.class);
            startActivity(intent);
        });
    }
}