package com.library.lms;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserActivityRequest extends AppCompatActivity {
    EditText ereq,edel;
    Button badd,bshow,bdel;
    DatabaseHelperStudent databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_request);
        ereq=findViewById(R.id.etreq);
        edel=findViewById(R.id.etdelete);
        bdel=findViewById(R.id.buttondelete);
        badd=findViewById(R.id.buttonreq);
        bshow=findViewById(R.id.showreq);
        databaseHelper=new DatabaseHelperStudent(getApplicationContext());
        badd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=ereq.getText().toString();
                if(s.equals("") || s.equals(null)){
                    Toast.makeText(getApplicationContext(),"Request unsuccessful",Toast.LENGTH_SHORT).show();
                }
                else {
                    boolean flag = databaseHelper.getreq(s);
                    if (flag == false) {
                        Toast.makeText(getApplicationContext(), "Request unsuccessful", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Request successful", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        bshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor=databaseHelper.showreq();

                if(cursor.getCount()==0){
                    Toast.makeText(getApplicationContext(),"NO DATA",Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    StringBuffer s1=new StringBuffer();
                    while ((cursor.moveToNext())) {
                        s1.append("Request : " + cursor.getString(0) + "\n");
                        s1.append("Book Name : " + cursor.getString(1) + "\n\n");
                    }
                    breqshow("DATA",s1.toString());
                }
            }
        });
        bdel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer i=databaseHelper.reqdel(edel.getText().toString());
                Toast.makeText(getApplicationContext(),"DATA DELETED",Toast.LENGTH_SHORT).show();
            }
        });
    }
    void breqshow(String s1,String s2){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(s1);
        builder.setMessage(s2);
        builder.show();
    }
}