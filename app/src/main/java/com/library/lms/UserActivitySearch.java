package com.library.lms;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class UserActivitySearch extends AppCompatActivity {

    RadioButton rc,re,rm,rciv,reee;
    Button button;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_search);
        rc=findViewById(R.id.rbcse);
        re=findViewById(R.id.rbece);
        rm=findViewById(R.id.rbmec);
        rciv=findViewById(R.id.rbciv);
        reee=findViewById(R.id.rbeee);
        button=findViewById(R.id.buttongo);
        listView=findViewById(R.id.lvsearch);


        ArrayList<String> arrayListcse=new ArrayList<String>();
        arrayListcse.add("  CSE BOOKS");
        arrayListcse.add("1. CSE1 Computer Programming");
        arrayListcse.add("2. CSE2 Object oriented Programming");
        arrayListcse.add("3. CSE3 Data Structures");
        arrayListcse.add("4. CSE4 Algorithms");
        arrayListcse.add("5. CSE5 Programming in Java");
        arrayListcse.add("6. CSE6 Operating System");
        arrayListcse.add("7. CSE7 Python programming");
        arrayListcse.add("8. CSE8 DBMS");
        arrayListcse.add("9. CSE9 HTML Lab");
        arrayListcse.add("10. CSE10 Computer organization");
        arrayListcse.add("11. CSE11 Software Engineering");
        arrayListcse.add("12. CSE12 Computer Networks");
        arrayListcse.add("13. CSE13 Cloud computing");

        ArrayList<String> arrayListece=new ArrayList<String>();
        arrayListece.add("  ECE BOOKS");
        arrayListece.add("1. ECE1 BASIC ELECTRICAL ENGINEERING");
        arrayListece.add("2. ECE2 BASIC ELECTRICAL ENGINEERING");
        arrayListece.add("3. ECE3 ELECTRONIC DEVICE AND CIRCUIT");
        arrayListece.add("4. ECE4 ELECTROMAGNETIC FIELD THEORY");
        arrayListece.add("5. ECE5 DIGITAL ELECTRONICS");
        arrayListece.add("6. ECE6 DIGITAL ELECTRONICS LABORATORY");
        arrayListece.add("7. ECE7 ARTIFICIAL INTELLIGENCE ");
        arrayListece.add("8. ECE8 DIGITAL SIGNAL PROCESSING");
        arrayListece.add("9. ECE9 CONTROL SYSTEM");
        arrayListece.add("10. ECE10 INDUSTRIAL AUTOMATATION");

        ArrayList<String> arrayListmec=new ArrayList<String>();
        arrayListmec.add("  MECHANICAL BOOKS");
        arrayListmec.add("1. MEC1 BASIC ENGINEERING MECHANICS");
        arrayListmec.add("2. MEC2 ENGINEERING DRAWING");
        arrayListmec.add("3. MEC3 ENGINEERING GRAPHICS");
        arrayListmec.add("4. MEC4 INTRO TO MECHANICAL ENGINEERING");
        arrayListmec.add("5. MEC5 MECHANICS OF SOLIDS");
        arrayListmec.add("6. MEC6 THERMODYNAMICS");
        arrayListmec.add("7. MEC7 KINEMATICS OF MECHANICS ");
        arrayListmec.add("8. MEC8 ENGINEERING MATERIALS");

        ArrayList<String> arrayListciv=new ArrayList<String>();
        arrayListciv.add("  CIVIL BOOKS");
        arrayListciv.add("1. CIV1 PROFESSIONAL ETHICS ");
        arrayListciv.add("2. CIV2 CONCRETE TECHNOLOGY");
        arrayListciv.add("3. CIV3 CLIMATE CHANGE AND SUSTAINABILITY");
        arrayListciv.add("4. CIV4 WATER SUPPLY AND WASTE WATER TREATMENT");
        arrayListciv.add("5. CIV5 BUILDING PLANNING AND BY LAWS");
        arrayListciv.add("6. CIV6 LABOUR MANAGEMENT");
        arrayListciv.add("7. CIV7 TRANSPORT INFRASTRUCTURE ");
        arrayListciv.add("8. CIV8 SOIL MECHANICS");

        ArrayList<String> arrayListeee=new ArrayList<String>();
        arrayListeee.add("  EEE BOOKS");
        arrayListeee.add("1. EEE1 Digital Electronics ");
        arrayListeee.add("2. EEE2 Microprocessor");
        arrayListeee.add("3. EEE3 Power Electronics");
        arrayListeee.add("4. EEE4 Digital Signal Processing");
        arrayListeee.add("5. EEE5 Utilization of Electrical Energy");
        arrayListeee.add("6. EEE6 VLSI Design & its Applications");
        arrayListeee.add("7. EEE7 Advanced Control Systems ");
        arrayListeee.add("8. EEE8 Flexible A.C. Transmission Systems");
        arrayListeee.add("9. EEE9 HVDC Transmission");
        arrayListeee.add("10. EEE10 Electrical Drives\t");





        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rc.isChecked()){
                    ArrayAdapter<String> arrayAdapter1cse=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,arrayListcse);
                    listView.setAdapter(arrayAdapter1cse);
                    Toast.makeText(getApplicationContext(),"CSE BOOKS",Toast.LENGTH_SHORT).show();
                }
                else if(re.isChecked()){
                    ArrayAdapter<String> arrayAdapter1ece=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,arrayListece);
                    listView.setAdapter(arrayAdapter1ece);
                    Toast.makeText(getApplicationContext(),"ECE BOOKS",Toast.LENGTH_SHORT).show();
                }
                else if(rm.isChecked()){
                    ArrayAdapter<String> arrayAdapter1mec=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,arrayListmec);
                    listView.setAdapter(arrayAdapter1mec);
                    Toast.makeText(getApplicationContext(),"MECHANICAL BOOKS",Toast.LENGTH_SHORT).show();
                }
                else if(rciv.isChecked()){
                    ArrayAdapter<String> arrayAdapter1civ=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,arrayListciv);
                    listView.setAdapter(arrayAdapter1civ);
                    Toast.makeText(getApplicationContext(),"CIVIL BOOKS",Toast.LENGTH_SHORT).show();
                }
                else if(reee.isChecked()){
                    ArrayAdapter<String> arrayAdapter1eee=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,arrayListeee);
                    listView.setAdapter(arrayAdapter1eee);
                    Toast.makeText(getApplicationContext(),"EEE BOOKS",Toast.LENGTH_SHORT).show();
                }
                else{
                    AlertDialog.Builder builder=new AlertDialog.Builder(UserActivitySearch.this);
                    builder.setCancelable(true);
                    builder.setTitle("Message");
                    builder.setMessage("Enter correct ID");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });AlertDialog d=builder.create();
                    d.show();
                }
            }
        });

    }

}