package com.jcupzz.ccenotes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.model.Document;

import static com.jcupzz.ccenotes.SFourSubjects.j;
import static com.jcupzz.ccenotes.StudentDetailsCategory.i;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    FirebaseFirestore db;
    RecyclerView mRecyclerView;
    ArrayList<DownModel> downModelArrayList = new ArrayList<>();
    MyAdapter myAdapter;
    public static String s4s6s8var;
Button upload_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        upload_btn = findViewById(R.id.upload_btn_id);

        if(StudentTeacherCategory.stc_integer==1)
        {
            upload_btn.setVisibility(View.GONE);
        }
        else if(StudentTeacherCategory.stc_integer==2)
        {
            upload_btn.setVisibility(View.VISIBLE);
        }
        else{
            //do nothing
        }

        upload_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,UploadActivity.class);
                startActivity(intent);
            }
        });

        //s4
        if(i==4&&j==1){
            s4s6s8var = "S4_CSE_MATHS";
        }
        if(i==4&&j==2){
            s4s6s8var = "S4_CSE_OS";
        }
        if(i==4&&j==3){
            s4s6s8var = "S4_CSE_DSL";
        }
        if(i==4&&j==4){
            s4s6s8var = "S4_CSE_PDD";
        }
        if(i==4&&j==5){
            s4s6s8var = "S4_CSE_COAA";
        }
        if(i==4&&j==6){
            s4s6s8var = "S4_CSE_OPDAP";
        }
        if(i==4&&j==7){
            s4s6s8var = "S4_CSE_FAOSSL";
        }


        //s6
        if(i==6&&j==1){
            s4s6s8var = "Physics";
        }
        if(i==6&&j==2){
            s4s6s8var = "S4_CSE_OS";
        }
        if(i==6&&j==3){
            s4s6s8var = "S4_CSE_DSL";
        }
        if(i==6&&j==4){
            s4s6s8var = "S4_CSE_PDD";
        }
        if(i==6&&j==5){
            s4s6s8var = "S4_CSE_COAA";
        }
        if(i==6&&j==6){
            s4s6s8var = "S4_CSE_OPDAP";
        }
        if(i==6&&j==7){
            s4s6s8var = "S4_CSE_FAOSSL";
        }


        //s8
        if(i==8&&j==1){
            s4s6s8var = "Chemistry";
        }
        if(i==8&&j==2){
            s4s6s8var = "S4_CSE_OS";
        }
        if(i==8&&j==3){
            s4s6s8var = "S4_CSE_DSL";
        }
        if(i==8&&j==4){
            s4s6s8var = "S4_CSE_PDD";
        }
        if(i==8&&j==5){
            s4s6s8var = "S4_CSE_COAA";
        }
        if(i==8&&j==6){
            s4s6s8var = "S4_CSE_OPDAP";
        }



        setUpFB();
        setUpRV();
        if(i==2) {
            dataFromFirebase();
        }
        else if(i==4||i==6||i==8)
            {
            dataFromFirebases6s4s8();
        }

    }

    private void dataFromFirebase() {
        if(downModelArrayList.size()>0)
            downModelArrayList.clear();

        //db=FirebaseFirestore.getInstance();


db.collection(STwoSubjects.var)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        for(DocumentSnapshot documentSnapshot: task.getResult()) {

                            DownModel downModel= new DownModel(documentSnapshot.getString("name"),
                                    documentSnapshot.getString("link"));
                            downModelArrayList.add(downModel);

                        }

                        myAdapter= new MyAdapter(MainActivity.this,downModelArrayList);
                        mRecyclerView.setAdapter(myAdapter);
                    }
                })

                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, "Error ;-.-;", Toast.LENGTH_SHORT).show();
                    }
                })
        ;


    }

    private void setUpFB(){
        db=FirebaseFirestore.getInstance();
    }

    private void setUpRV(){
        mRecyclerView= findViewById(R.id.recycle);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void dataFromFirebases6s4s8() {
        if(downModelArrayList.size()>0)
            downModelArrayList.clear();

        //db=FirebaseFirestore.getInstance();


        db.collection(s4s6s8var)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        for(DocumentSnapshot documentSnapshot: task.getResult()) {

                            DownModel downModel= new DownModel(documentSnapshot.getString("name"),
                                    documentSnapshot.getString("link"));
                            downModelArrayList.add(downModel);

                        }

                        myAdapter= new MyAdapter(MainActivity.this,downModelArrayList);
                        mRecyclerView.setAdapter(myAdapter);
                    }
                })

                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, "Error ;-.-;", Toast.LENGTH_SHORT).show();
                    }
                })
        ;


    }


}
