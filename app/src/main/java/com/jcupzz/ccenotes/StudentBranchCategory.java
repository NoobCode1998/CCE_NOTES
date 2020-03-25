package com.jcupzz.ccenotes;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class StudentBranchCategory extends AppCompatActivity implements View.OnClickListener {
public static Button b_b_civil;
    public static  Button b_b_electrical;
    public static  Button b_b_electronics;
    public static  Button b_b_cs;
    public static  Button b_b_mechanical;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_branch_category);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Select Your Department");

         b_b_civil = findViewById(R.id.b_b_id_civil);
         b_b_electrical = findViewById(R.id.b_b_id_electrical);
         b_b_electronics  = findViewById(R.id.b_b_id_electronics);
         b_b_cs = findViewById(R.id.b_b_id_cs);
         b_b_mechanical = findViewById(R.id.b_b_id_mechanical);

         b_b_civil.setOnClickListener(this);
         b_b_electrical.setOnClickListener(this);
         b_b_electronics.setOnClickListener(this);
         b_b_cs.setOnClickListener(this);
         b_b_mechanical.setOnClickListener(this);

    }





    @Override
    public void onClick(View v) {

        if(StudentDetailsCategory.i==1) {
            Intent ins = new Intent(StudentBranchCategory.this, SFourSubjects.class);
            startActivity(ins);
        }
        if(StudentDetailsCategory.i==2) {
            Intent ins = new Intent(StudentBranchCategory.this, SSixSubjects.class);
            startActivity(ins);
        }
        if(StudentDetailsCategory.i==3) {
            Intent ins = new Intent(StudentBranchCategory.this, SEightSubjects.class);
            startActivity(ins);
        }
}

}
