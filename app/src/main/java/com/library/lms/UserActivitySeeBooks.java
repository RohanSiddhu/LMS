package com.library.lms;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class UserActivitySeeBooks extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_see_books);
        listView=findViewById(R.id.list);
        ArrayList<String> arrayList=new ArrayList<>();
        arrayList.add("1. Computer Fundamentals and Programming in C \n");
        arrayList.add("2. Everything You Need to Know to Ace Computer Science and Coding (Workman Publishing, 2020) \n");
        arrayList.add("3. A Programmer’s Guide to Computer Science (Dr. William Springer, 2019)");
        arrayList.add("4. Code Complete (Steve McConnell, 2004) \n");
        arrayList.add("5. The Pragmatic Programmer (Andrew Hunt, 1999) \n");
        arrayList.add("6. Algorithms 4th Edition (Robert Sedgewick, 2011) \n");
        arrayList.add("7. Programming Collective Intelligence (Toby Segaran, 2007) \n");
        arrayList.add("8. Cybersecurity for Beginners (Raef Meeuwisse, 2017) \n");
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"BOOK "+(position+1)+" is clicked",Toast.LENGTH_SHORT).show();
            }
        });
    }
}