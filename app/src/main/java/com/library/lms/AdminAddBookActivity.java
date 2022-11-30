package com.library.lms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.library.lms.DB.AppDatabase;
import com.library.lms.DB.Books;
import com.library.lms.DB.BooksDao;

public class AdminAddBookActivity extends AppCompatActivity {
    AppDatabase dbRoom;
    BooksDao booksDao;

    EditText isbnField;
    EditText titleField;
    EditText authorField;
    EditText totalField;
    EditText availableField;

    Button addButton;
    Button cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_book_add);

        // Init Database
        dbRoom = AppDatabase.getInstance(this);
        booksDao = dbRoom.booksDao();

        isbnField = findViewById(R.id.et_add_isbn);
        titleField = findViewById(R.id.et_add_title);
        authorField = findViewById(R.id.et_add_author);
        totalField = findViewById(R.id.et_add_total);
        availableField = findViewById(R.id.et_add_available);

        addButton = findViewById(R.id.btnAdd);
        cancelButton = findViewById(R.id.btnCancel);

        setListeners();
    }

    private void setListeners() {
        addButton.setOnClickListener(view -> {
            long isbn = Long.parseLong(isbnField.getText().toString());
            String title = titleField.getText().toString();
            String author = authorField.getText().toString();
            int total = Integer.parseInt(totalField.getText().toString());
            int available = Integer.parseInt(availableField.getText().toString());

            if (booksDao.present(isbn) == 0) {
                booksDao.insertAll(new Books(isbn, title, author, total, available));
                Toast.makeText(this, "Book Added", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Failed: Duplicate Entry", Toast.LENGTH_SHORT).show();
            }

            this.finish();
        });
        cancelButton.setOnClickListener(view -> {
            this.finish();
        });
    }
}