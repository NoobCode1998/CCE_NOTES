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

import static com.jcupzz.ccenotes.SFourSubjects.k;
import static com.jcupzz.ccenotes.StudentBranchCategory.j;
import static com.jcupzz.ccenotes.StudentDetailsCategory.i;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    FirebaseFirestore db;
    RecyclerView mRecyclerView;
    ArrayList<DownModel> downModelArrayList = new ArrayList<>();
    MyAdapter myAdapter;
    public static String s4s6s8var;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//civil
        if(j==1&&k==1){
            s4s6s8var = "Mathematics";
        }
        if(j==1&&k==2)
        {
            s4s6s8var = "Chemistry";
        }
        if(j==1&&k==3)
        {
            s4s6s8var = "Physics";
        }
        if(j==1&&k==4)
        {
            s4s6s8var = "Physics";
        }
        if(j==1&&k==5)
        {
            s4s6s8var = "Physics";
        }
        if(j==1&&k==6)
        {
            s4s6s8var = "Physics";
        }
        if(j==1&&k==7)
        {
            s4s6s8var = "Physics";
        }


       //cs


        if(j==2&&k==11){
            s4s6s8var = "Chemistry";
        }
        if(j==2&&k==22)
        {
            s4s6s8var = "Physics";
        }
        if(j==2&&k==33)
        {
            s4s6s8var = "Physics";
        }
        if(j==2&&k==44)
        {
            s4s6s8var = "Physics";
        }
        if(j==2&&k==55)
        {
            s4s6s8var = "Physics";
        }
        if(j==2&&k==66)
        {
            s4s6s8var = "Physics";
        }
        if(j==2&&k==77)
        {
            s4s6s8var = "Physics";
        }
//electrical

        if(j==3&&k==111){
            s4s6s8var = "Mathematics";
        }
        if(j==3&&k==222)
        {
            s4s6s8var = "Physics";
        }
        if(j==3&&k==333)
        {
            s4s6s8var = "Physics";
        }
        if(j==3&&k==444)
        {
            s4s6s8var = "Mechanics";
        }
        if(j==3&&k==555)
        {
            s4s6s8var = "Physics";
        }

        if(j==3&&k==666)
        {
            s4s6s8var = "Physics";
        }

        if(j==3&&k==777)
        {
            s4s6s8var = "Physics";
        }

 //electronics

        if(j==4&&k==1111){
            s4s6s8var = "Electronics";
        }
        if(j==4&&k==2222)
        {
            s4s6s8var = "Physics";
        }
        if(j==4&&k==3333)
        {
            s4s6s8var = "Physics";
        }
        if(j==4&&k==4444)
        {
            s4s6s8var = "Mechanics";
        }
        if(j==4&&k==5555)
        {
            s4s6s8var = "Physics";
        }

        if(j==4&&k==6666)
        {
            s4s6s8var = "Physics";
        }

        if(j==4&&k==7777)
        {
            s4s6s8var = "Physics";
        }
//Mechanical
        if(j==5&&k==11111){
            s4s6s8var = "Mechanical";
        }
        if(j==5&&k==22222)
        {
            s4s6s8var = "Physics";
        }
        if(j==5&&k==33333)
        {
            s4s6s8var = "Physics";
        }
        if(j==5&&k==44444)
        {
            s4s6s8var = "Mechanics";
        }
        if(j==5&&k==55555)
        {
            s4s6s8var = "Physics";
        }

        if(j==5&&k==66666)
        {
            s4s6s8var = "Physics";
        }

        if(j==5&&k==77777)
        {
            s4s6s8var = "Physics";
        }



        setUpFB();
        setUpRV();
        if(i==0) {
            dataFromFirebase();
        }
        else if(i==1||i==2||i==3)
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
