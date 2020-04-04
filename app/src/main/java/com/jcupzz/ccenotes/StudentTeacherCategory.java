package com.jcupzz.ccenotes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;

public class StudentTeacherCategory extends MainActivity {
    ImageButton stu_btn, teachers_btn;
    Button log_btn;
    public static int stc_integer=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_student_teacher_category);


        stu_btn = findViewById(R.id.student_btn);
        log_btn = findViewById(R.id.logout_btn);

        if(FirebaseAuth.getInstance().getCurrentUser() == null)
            log_btn.setVisibility(View.GONE);
//
//        if (StudentTeacherCategory.stc_integer == 2) {
//            log_btn.setVisibility(View.VISIBLE);
//        } else {
//            log_btn.setVisibility(View.GONE);
//        }


        teachers_btn = findViewById(R.id.teacher_category_btn);

        stu_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentTeacherCategory.this, StudentDetailsCategory.class);
                startActivity(intent);
                stc_integer = 1;
            }
        });

        teachers_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (FirebaseAuth.getInstance().getCurrentUser() != null) {
                    stc_integer = 2;
                    log_btn.setVisibility(View.VISIBLE);
                    Intent intent = new Intent(StudentTeacherCategory.this, StudentDetailsCategory.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(StudentTeacherCategory.this, Register.class);
                    startActivity(intent);
                }
            }
        });

        log_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                stc_integer = 1;
                finish();

            }
        });


    }


}