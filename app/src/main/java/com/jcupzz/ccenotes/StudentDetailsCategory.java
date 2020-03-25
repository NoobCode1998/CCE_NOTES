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

public class StudentDetailsCategory extends AppCompatActivity  {
    public static Button btn_s2,btn_s4,btn_s6,btn_s8;
    public static int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details_category);

        btn_s2 = findViewById(R.id.img_id_s2);
        btn_s4 = findViewById(R.id.img_id_s4);
        btn_s6 = findViewById(R.id.img_id_s6);
        btn_s8 = findViewById(R.id.img_id_s8);



btn_s2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent s2 = new Intent(StudentDetailsCategory.this,STwoSubjects.class);
        startActivity(s2);
        i=0;
    }
});
        btn_s4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
i=1;
                Intent s24 = new Intent(StudentDetailsCategory.this,StudentBranchCategory.class);
                startActivity(s24);
            }
        });
        btn_s6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
    i=2;
                Intent s26 = new Intent(StudentDetailsCategory.this,StudentBranchCategory.class);
                startActivity(s26);
            }
        });
        btn_s8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        i=3;
                Intent s28 = new Intent(StudentDetailsCategory.this,StudentBranchCategory.class);
                startActivity(s28);
            }
        });

        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.actionbar_gradient));


    }


}

