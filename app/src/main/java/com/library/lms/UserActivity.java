package com.library.lms;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class UserActivity extends AppCompatActivity {
    Button bsrch;
    Button bsee;
    Button bret;
    Button blog;
    Button breq;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_close) {
            UserActivity.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        bsrch=findViewById(R.id.btnsearch);
        bsee=findViewById(R.id.btnsee);
        bret=findViewById(R.id.btnreturn);
        blog=findViewById(R.id.btnlogout);
        breq=findViewById(R.id.btnrequest);



        bsrch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),UserActivitySearch.class);
                startActivity(intent);
            }
        });
        bsee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),UserActivitySeeBooks.class);
                startActivity(intent);
            }
        });
        bret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),UserActivityReturn.class);
                startActivity(i);
            }
        });
        breq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),UserActivityRequest.class);
                startActivity(intent);
            }
        });
    }
}