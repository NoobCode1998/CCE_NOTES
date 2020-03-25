package com.jcupzz.ccenotes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class SFourSubjects extends AppCompatActivity {
ListView listView;
String [] variable = {"Mathematics","Computer Organization and Architecture","Operating Systems","Object Oriented Design and Programming"
        ,"Principles of Database Design","Free and Open Source Software Lab","Digital Systems Lab"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sfour_subjects);

        listView = findViewById(R.id.listview_id);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,variable);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int itempostion = position;
                Toast.makeText(SFourSubjects.this,"You Have Clicked Item at Position:"+itempostion,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
