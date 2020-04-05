package com.jcupzz.ccenotes;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.scwang.wave.MultiWaveHeader;

import java.util.ArrayList;
import java.util.List;

public class StudentDetailsCategory extends MainActivity{
    public static Button btn_s2,btn_s4,btn_s6,btn_s8;
    public static int i;
MultiWaveHeader waveHeader_sdc,waveFooter_sdc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details_category);

        btn_s2 = findViewById(R.id.img_id_s2);
        btn_s4 = findViewById(R.id.img_id_s4);
        btn_s6 = findViewById(R.id.img_id_s6);
        btn_s8 = findViewById(R.id.img_id_s8);

waveHeader_sdc=findViewById(R.id.wave_head_id);
waveFooter_sdc=findViewById(R.id.wave_fot_id);


        waveFooter_sdc.setVelocity(2);
        waveFooter_sdc.setProgress(1);
        waveFooter_sdc.isRunning();
        waveFooter_sdc.setGradientAngle(45);
        waveFooter_sdc.setWaveHeight(40);
        waveFooter_sdc.setStartColor(getResources().getColor(R.color.wave_start));
        waveFooter_sdc.setCloseColor(getResources().getColor(R.color.wave_end));

        waveHeader_sdc.setVelocity(2);
        waveHeader_sdc.setProgress(1);
        waveHeader_sdc.isRunning();
        waveHeader_sdc.setGradientAngle(45);
        waveHeader_sdc.setWaveHeight(40);
        waveHeader_sdc.setStartColor(getResources().getColor(R.color.wave_end));
        waveHeader_sdc.setCloseColor(getResources().getColor(R.color.wave_start));




        btn_s2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent s2 = new Intent(StudentDetailsCategory.this,STwoSubjects.class);
        startActivity(s2);
        i=2;
    }
});
        btn_s4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
i=4;
                Intent s4 = new Intent(StudentDetailsCategory.this,SFourSubjects.class);
                startActivity(s4);
            }
        });
        btn_s6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
    i=6;
                Intent s6 = new Intent(StudentDetailsCategory.this,SSixSubjects.class);
                startActivity(s6);
            }
        });
        btn_s8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        i=8;
                Intent s8 = new Intent(StudentDetailsCategory.this,SEightSubjects.class);
                startActivity(s8);
            }
        });

       // ActionBar actionBar = getSupportActionBar();
       // actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.actionbar_gradient));






    }


}

