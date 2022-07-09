package com.library.lms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class UserActivityReturn extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_return);
        listView=findViewById(R.id.lvreturn);
        ArrayList<String> arrayList=new ArrayList<>();
        arrayList.add("1. Hackers: Heroes of the Computer Revolution, by Steven Levy \n");
        arrayList.add("2. Daily Coding Problem \n");
        arrayList.add("3. Algorithms to Live By: The Computer Science of Human Decisions, by Brian Christian and Tom Griffiths");
        arrayList.add("4. The Innovators \n");
        arrayList.add("5. Social Engineering \n");
        arrayList.add("6. Clean Code: A Handbook of Agile Software Craftsmanship \n");

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);
    }
}