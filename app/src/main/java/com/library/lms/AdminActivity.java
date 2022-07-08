package com.library.lms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.util.ArrayList;

public class AdminActivity extends AppCompatActivity {
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        gridView = findViewById(R.id.gridView);

        ArrayList<GridData> list = new ArrayList<>();

        list.add(new GridData(R.drawable.ic_launcher_foreground, "Books"));
        list.add(new GridData(R.drawable.ic_launcher_foreground, "Users"));
        list.add(new GridData(R.drawable.ic_launcher_foreground, "History"));
        list.add(new GridData(R.drawable.ic_launcher_foreground, "Notifications"));

        GridAdapter adapter = new GridAdapter(this, list);
        gridView.setAdapter(adapter);
    }
}