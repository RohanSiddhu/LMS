package com.library.lms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signUp extends AppCompatActivity {
    EditText name, username,pass, repass,email;
    Button btn;

    DBhelper g;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        name= findViewById(R.id.name);
        username= findViewById(R.id.username);
        pass= findViewById(R.id.password);
        repass = findViewById(R.id.repassword);
        email = findViewById(R.id.email);
        btn = findViewById(R.id.saveUser);

        g = new DBhelper(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sname = name.getText().toString();
                String sUserName = username.getText().toString();
                String sEmail = email.getText().toString();
                String sPass = pass.getText().toString();
                String sRePass = repass.getText().toString();
                if(sname.equals("") || sUserName.equals("") || sPass.equals("") || sRePass.equals("") || sEmail.equals("")){
                    Toast.makeText(signUp.this, "Please enter all fields", Toast.LENGTH_SHORT).show();

                }
                else {
                    if (sPass.equals(sRePass)) {
                        boolean checkuser = g.checkuser(sEmail);
                        if(checkuser==false){
                            boolean i=  g.insertData(sname,sUserName,sEmail,sPass);
                            if(i== true){
                                Toast.makeText(signUp.this, "Saved", Toast.LENGTH_SHORT).show();
                                //write home page of student
                            }
                            else
                                Toast.makeText(signUp.this, "Unable to save", Toast.LENGTH_SHORT).show();
                        }
                        else
                            Toast.makeText(signUp.this, "User already exist", Toast.LENGTH_SHORT).show();
                    }
                    else
                        Toast.makeText(signUp.this, "Password does not match", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}