package com.library.lms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class AdminAddBookActivity extends AppCompatActivity {
    Button addButton;
    Button cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_book);

        addButton = findViewById(R.id.btnAdd);
        cancelButton = findViewById(R.id.btnCancel);

        setListeners();
    }

    private void setListeners() {
        addButton.setOnClickListener(view -> {
            Toast.makeText(this, "Book Added", Toast.LENGTH_SHORT).show();
            this.finish();
        });
        cancelButton.setOnClickListener(view -> {
            this.finish();
        });
    }
}