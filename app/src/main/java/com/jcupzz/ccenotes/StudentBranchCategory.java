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
    public static    Button b_b_electrical;
    public static    Button b_b_electronics;
    public static    Button b_b_cs;
    public static    Button b_b_mechanical;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_branch_category);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Select Your Department");

         b_b_civil = findViewById(R.id.b_b_id_civil);
         b_b_electrical = findViewById(R.id.b_b_id_electrical);
         b_b_electronics  = findViewById(R.id.b_b_id_electronics);
         b_b_cs = findViewById(R.id.s2_btn_cs);
         b_b_mechanical = findViewById(R.id.s2_btn_basics_of_mechanical);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(StudentBranchCategory.this,MainActivity.class);
        startActivity(intent);


    }

}
