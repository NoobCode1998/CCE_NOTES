package com.jcupzz.ccenotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class STwoSubjects extends AppCompatActivity implements View.OnClickListener{
public static String var;
    public static Button s2_btn_physics;
    public static Button s2_btn_chemistry;
    public static Button s2_btn_graphics;
    public static Button s2_btn_basics_of_mechanics;
    public static Button s2_btn_basics_of_electrical;
    public static Button s2_btn_basics_of_electronics;
    public static Button s2_btn_mathematics;
    public static Button s2_btn_cs;
    public static Button s2_btn_basics_of_mechanical;
    public static Button s2_btn_basics_of_civil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stwo_subjects);

        //start variables
         s2_btn_physics = findViewById(R.id.s2_btn_physics);
        s2_btn_chemistry = findViewById(R.id.s2_btn_chemistry);
        s2_btn_graphics = findViewById(R.id.s2_btn_graphics);
        s2_btn_basics_of_mechanics = findViewById(R.id.s2_btn_basics_of_mechanics);
        s2_btn_basics_of_electrical = findViewById(R.id.s2_btn_basics_of_electrical);
        s2_btn_basics_of_electronics = findViewById(R.id.s2_btn_basics_of_electronics);
        s2_btn_mathematics = findViewById(R.id.s2_btn_mathematics);
        s2_btn_cs = findViewById(R.id.s2_btn_cs);
        s2_btn_basics_of_mechanical = findViewById(R.id.s2_btn_basics_of_mechanical);
        s2_btn_basics_of_civil = findViewById(R.id.s2_btn_basics_of_civil);
        //end variables
        //OnClickListenerFunction Starts:-
        s2_btn_cs.setOnClickListener(this);
        s2_btn_basics_of_civil.setOnClickListener(this);
        s2_btn_basics_of_mechanical.setOnClickListener(this);
        s2_btn_basics_of_mechanics.setOnClickListener(this);
        s2_btn_basics_of_electronics.setOnClickListener(this);
        s2_btn_basics_of_electrical.setOnClickListener(this);
        s2_btn_physics.setOnClickListener(this);
        s2_btn_chemistry.setOnClickListener(this);
        s2_btn_mathematics.setOnClickListener(this);
        s2_btn_graphics.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(STwoSubjects.this,MainActivity.class);
        startActivity(intent);
        switch (v.getId()) {
            case R.id.s2_btn_physics:
                var = "Physics";
                break;
            case R.id.s2_btn_chemistry:
                var = "Chemistry";
                break;
            case R.id.s2_btn_graphics:
                var = "Graphics";
                break;
            case R.id.s2_btn_basics_of_mechanics:
                var = "Mechanics";
                break;
            case R.id.s2_btn_basics_of_mechanical:
                var = "Mechanical";
                break;
            case R.id.s2_btn_basics_of_civil:
                var = "Civil";
                break;
            case R.id.s2_btn_cs:
                var = "Cs";
                break;
            case R.id.s2_btn_mathematics:
                var = "Mathematics";
                break;
            case R.id.s2_btn_basics_of_electrical:
                var = "Electrical";
                break;
            case R.id.s2_btn_basics_of_electronics:
                var = "Electronics";
                break;

        }

        }

    }

