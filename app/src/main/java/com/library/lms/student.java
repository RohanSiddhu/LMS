package com.library.lms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class student extends AppCompatActivity {
    EditText email, pass;
    DBhelper db ;
    Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);


        email = findViewById(R.id.emailNO);
        pass = findViewById(R.id.passNO);
        loginBtn= findViewById(R.id.logBtn);

        db= new DBhelper(this);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String smail = email.getText().toString();
                String spass = pass.getText().toString();

                if(smail.equals("")||spass.equals(""))
                {
                    Toast.makeText(student.this, "Please enter the mandatory field", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    boolean check = db.checkuserpass(smail,spass);
                    if(check == true){
                        Toast.makeText(student.this, "Welcome", Toast.LENGTH_SHORT).show();
                        // write intent function to ho to student page
                    }
                    else
                        Toast.makeText(student.this, "Invalid credential", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}