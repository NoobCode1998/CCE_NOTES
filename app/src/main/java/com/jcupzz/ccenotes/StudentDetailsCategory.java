package com.jcupzz.ccenotes;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class StudentDetailsCategory extends AppCompatActivity {
    ImageButton btn_s2,btn_s4,btn_s6,btn_s8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details_category);

        btn_s2 = findViewById(R.id.img_id_s2);
        btn_s4 = findViewById(R.id.img_id_s4);
        btn_s6 = findViewById(R.id.img_id_s6);
        btn_s8 = findViewById(R.id.img_id_s8);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.actionbar_gradient));


        btn_s2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

        Intent s2intent = new Intent(StudentDetailsCategory.this,STwoSubjects.class);
        startActivity(s2intent);

            }
        });
        btn_s4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent s4intent = new Intent(StudentDetailsCategory.this,StudentBranchCategory.class);
                startActivity(s4intent);

            }
        });
        btn_s6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent s6intent = new Intent(StudentDetailsCategory.this,StudentBranchCategory.class);
                startActivity(s6intent);

            }
        });
        btn_s8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent s8intent = new Intent(StudentDetailsCategory.this,StudentBranchCategory.class);
                startActivity(s8intent);

            }
        });



    }


}

