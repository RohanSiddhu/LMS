package com.library.lms;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminUsersActivity extends AppCompatActivity {
    Button add, del, view;
    DBhelper g;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_option);

        add = findViewById(R.id.add_btn);
        del = findViewById(R.id.del_btn);
        view = findViewById(R.id.View_btn);

        g = new DBhelper(this);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor t = g.getInfo();
                if (t.getCount() == 0) {
                    Toast.makeText(AdminUsersActivity.this, "No data", Toast.LENGTH_SHORT).show();
                } else {
                    StringBuffer buffer = new StringBuffer();
                    while (t.moveToNext()) {
                        buffer.append("Name: " + t.getString(1) + "\n");
                        buffer.append("Username " + t.getString(2) + "\n");
                        buffer.append("Email " + t.getString(3) + "\n\n");

                    }
                    AlertDialog.Builder builder = new AlertDialog.Builder(AdminUsersActivity.this);
                    builder.setCancelable(true);
                    builder.setTitle("Sign up user");
                    builder.setMessage(buffer.toString());
                    builder.show();
                }
            }
        });

    }

    public void action2(View view) {
        Intent i = new Intent(getApplicationContext(), signUp.class);
        startActivity(i);
    }


    public void show_del_dialog(View view) {
        final AlertDialog.Builder alert = new AlertDialog.Builder(AdminUsersActivity.this);
        View mView = getLayoutInflater().inflate(R.layout.del_dialog, null);

        final EditText inputEmail = (EditText) mView.findViewById(R.id.txt_input);
        Button btn_cancel = (Button) mView.findViewById(R.id.btn_cancel);
        Button btn_ok = (Button) mView.findViewById(R.id.btn_ok);
        alert.setView(mView);

        final AlertDialog alertdialog = alert.create();
        alertdialog.setCancelable(true);


        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertdialog.dismiss();

            }
        });

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getText = inputEmail.getText().toString();
                alertdialog.dismiss();
                boolean i = g.delete_data(getText);
                if (i)
                    Toast.makeText(AdminUsersActivity.this, "Deleted Successfully", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(AdminUsersActivity.this, "user not found", Toast.LENGTH_SHORT).show();
            }
        });
        alertdialog.show();
    }
}