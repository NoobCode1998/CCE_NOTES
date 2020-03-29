



package com.jcupzz.ccenotes;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class StudentTeacherCategory extends AppCompatActivity {
    ImageButton stu_btn,teachers_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_teacher_category);


        stu_btn = findViewById(R.id.student_category_btn);
        teachers_btn=findViewById(R.id.teacher_category_btn);

        stu_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentTeacherCategory.this,StudentDetailsCategory.class);
                startActivity(intent);
            }
        });

        teachers_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentTeacherCategory.this,Login.class);
                startActivity(intent);
            }
        });

    }
}
