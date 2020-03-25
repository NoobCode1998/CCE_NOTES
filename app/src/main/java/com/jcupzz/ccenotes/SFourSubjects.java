package com.jcupzz.ccenotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import static com.jcupzz.ccenotes.StudentBranchCategory.j;
import static com.jcupzz.ccenotes.StudentDetailsCategory.i;

public class SFourSubjects extends AppCompatActivity {
ListView listView;
public static int k;
String[] variable;
String [] cse = {"Mathematics","Computer Organization and Architecture","Operating Systems","Object Oriented Design and Programming"
        ,"Principles of Database Design","Free and Open Source Software Lab","Digital Systems Lab"};
String [] mech = {"Mathematics" ,
        "Advanced Mechanics of Solids" ,
        "Thermal Engineering",
        "Fluid Machinery" ,
        "Manufacturing Technology" ,
        "Thermal Engineering Lab" ,
        "Fluid Mechanics & Machines Lab"};
String [] civ={"Mathematics",
        "Structural Analysis" ,
        "Construction Technology",
        "Fluid Mechanics II ",
        "Geotechnical Engineering I",
        "Materials Testing Lab",
        "Fluid Mechanics Lab"};
String [] electrical = {"Mathematics","Signals and Systems","Analog Integrated Circuits","Computer Organization","Analog Communication Engineering","Logic Circuit Design Lab","Analog Integrated Circuits Lab"};
String [] electronics ={"Mathematics","Synchronous and Induction Machines","Digital Electronics and Logic Design","Material Science","Measurements and Instrumentation","Electrical Machines Lab","Circuits and Measurements Lab"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sfour_subjects);

        if(i==1&&j==1){
variable = civ;
        }
        if(i==1&&j==2){
variable = cse;
        }
        if(i==1&&j==3){
variable = electrical;
        }
        if(i==1&&j==4){
variable = electronics;
        }
        if(i==1&&j==5){
variable = mech;
        }


        listView = findViewById(R.id.listview_id);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,variable);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(StudentBranchCategory.j==1) {
                    switch (position) {
                        case 0:
                            k = 1;
                            break;
                        case 1:
                            k = 2;
                            break;
                        case 2:
                            k = 3;
                            break;
                        case 3:
                            k = 4;
                            break;
                        case 4:
                            k = 5;
                            break;
                        case 5:
                            k = 6;
                            break;
                        case 6:
                            k = 7;
                            break;

                    }
                }

                if(StudentBranchCategory.j==2) {
                    switch (position) {
                        case 0:
                            k = 11;
                            break;
                        case 1:
                            k = 22;
                            break;
                        case 2:
                            k = 33;
                            break;
                        case 3:
                            k = 44;
                            break;
                        case 4:
                            k = 55;
                            break;
                        case 5:
                            k = 66;
                            break;
                        case 6:
                            k = 77;
                            break;

                    }
                }

                if(StudentBranchCategory.j==3) {
                    switch (position) {
                        case 0:
                            k = 111;
                            break;
                        case 1:
                            k = 222;
                            break;
                        case 2:
                            k = 333;
                            break;
                        case 3:
                            k = 444;
                            break;
                        case 4:
                            k = 555;
                            break;
                        case 5:
                            k = 666;
                            break;
                        case 6:
                            k = 777;
                            break;

                    }
                }
                if(StudentBranchCategory.j==4) {
                    switch (position) {
                        case 0:
                            k = 1111;
                            break;
                        case 1:
                            k = 2222;
                            break;
                        case 2:
                            k = 3333;
                            break;
                        case 3:
                            k = 4444;
                            break;
                        case 4:
                            k = 5555;
                            break;
                        case 5:
                            k = 6666;
                            break;
                        case 6:
                            k = 7777;
                            break;

                    }
                }
                if(StudentBranchCategory.j==5) {
                    switch (position) {
                        case 0:
                            k = 11111;
                            break;
                        case 1:
                            k = 22222;
                            break;
                        case 2:
                            k = 33333;
                            break;
                        case 3:
                            k = 44444;
                            break;
                        case 4:
                            k = 55555;
                            break;
                        case 5:
                            k = 66666;
                            break;
                        case 6:
                            k = 77777;
                            break;

                    }
                }
Intent intenting = new Intent(SFourSubjects.this,MainActivity.class);
                startActivity(intenting);
              //  Toast.makeText(SFourSubjects.this,"You Have Clicked Item at Position:"+itempostion,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
