package com.library.lms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class teacher extends AppCompatActivity {
    EditText empNo, pass;
    Button logTin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);

        empNo =findViewById(R.id.empNO);
        pass= findViewById(R.id.passnO);
        logTin = findViewById(R.id.loginTeacher);


        logTin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sEmpNo = empNo.getText().toString();
                String slog = pass.getText().toString();

                if(sEmpNo.equals("")|| slog.equals("")){
                    Toast.makeText(teacher.this, "please enter mandatory field", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(sEmpNo.equals("12012") && slog.equals("12345678")){
                        Intent i = new Intent(getApplicationContext(), AdminActivity.class);
                        startActivity(i);
                        Toast.makeText(teacher.this, "Welcome", Toast.LENGTH_SHORT).show();
                        //add intent function to gop to teacher page


                    }
                    else
                        Toast.makeText(teacher.this, "Invalid credential", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}