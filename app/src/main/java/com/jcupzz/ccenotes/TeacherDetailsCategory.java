package com.jcupzz.ccenotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;




public class TeacherDetailsCategory extends MainActivity {
Button confirm_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_details_category);

confirm_btn = findViewById(R.id.confirm_button);

confirm_btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intr = new Intent(TeacherDetailsCategory.this,StudentDetailsCategory.class);
        startActivity(intr);

    }
});


    }
}
