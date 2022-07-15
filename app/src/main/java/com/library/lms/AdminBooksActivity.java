package com.library.lms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import com.library.lms.Adapter.*;
import com.library.lms.DB.AppDatabase;
import com.library.lms.DB.Books;
import com.library.lms.DB.BooksDao;


public class AdminBooksActivity extends AppCompatActivity {
    ListView listView;
    ImageView searchButton;

    AppDatabase dbRoom;
    BooksDao booksDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);

        listView = findViewById(R.id.listView_books);
        searchButton = findViewById(R.id.button_search);

        dbRoom = AppDatabase.getInstance(this);

        booksDao = dbRoom.booksDao();
        List<Books> books = booksDao.getAll();
        if (books.size() == 0) {
            booksDao.insertAll(
                    new Books(978_81_203_4007_7L, "Introduction To Algorithms", "Thomas H. Cormen, Charles E. Leiserson, Ronald L. Rivest, Clifford Stein", 5, 3),
                    new Books(978_81_265_5427_0L, "Operating System Concepts", "Abraham Silberschatz, Peter B Galvin, Greg Gagne", 7, 6),
                    new Books(978_93_87432_29_1L, "Java: The Complete Reference, Tenth Edition", "Herbert Schildt", 3, 2)
            );
            books = booksDao.getAll();
        }

        BookAdapter adapter = new BookAdapter(this, books);
        listView.setAdapter(adapter);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Search Books", Toast.LENGTH_SHORT).show();
            }
        });
    }
}