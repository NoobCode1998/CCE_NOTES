package com.jcupzz.ccenotes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;



import android.os.Bundle;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

public class Login extends AppCompatActivity {

    private EditText name;
    private EditText pass;
    private Button login;
    private int counter=5;
    private TextView wrAtmt;
    private FirebaseAuth firebaseAuth;
    String userID;

    FirebaseFirestore db =FirebaseFirestore.getInstance();

    public Login() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        name = (EditText)findViewById(R.id.edUID);
        pass = (EditText)findViewById(R.id.edUPASS);
        login =(Button)findViewById(R.id.USUB);
        wrAtmt=(TextView)findViewById(R.id.WrAttempt);


        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();

        if(user!=null){
            finish();
            startActivity(new Intent(Login.this,StudentDetailsCategory.class));
        }



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(name.getText().toString().trim(),pass.getText().toString().trim());
            }
        });

    }


    private void validate(final String userName, String userPass)
    {
//        if(userName.equals("Admin") && userPass.equals("letmein"))
//        {
//            Intent intent = new Intent(MainActivity.this, AdminActivity.class);
//            startActivity(intent);
//
//        }
//
//        else{
//            counter--;
//
//            wrAtmt.setText("Number of attempts remaining :" + String.valueOf(counter));
//            if(counter==0){
//                login.setEnabled(false);
//            }
         firebaseAuth.signInWithEmailAndPassword(userName,userPass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){
                    StudentTeacherCategory.log_btn.setVisibility(View.VISIBLE);
                    Toast.makeText(Login.this,"Login succesfull",Toast.LENGTH_SHORT).show();
                    //StudentTeacherCategory.stc_integer=2;
                    //cp
                    DocumentReference docRef = db.collection("roles").document(userName);
                    docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                            if (task.isSuccessful()) {
                                DocumentSnapshot document = task.getResult();
                                if (document != null) {
                                    if(document.getString("uploadRight").equals("1")){
                                        //activate upload
                                        Toast.makeText(Login.this,"upload active",Toast.LENGTH_SHORT).show();
                                        StudentTeacherCategory.stc_integer=2;
                                    }
                                    else{
                                        //upload deactive
                                        StudentTeacherCategory.stc_integer=1;
                                        Toast.makeText(Login.this,"uplaod deactive",Toast.LENGTH_SHORT).show();
                                    }
                                } else {
                                    Log.d("LOGGER", "No such document");
                                    Toast.makeText(Login.this,"coudnt find doc",Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Log.d("LOGGER", "get failed with ", task.getException());
                                Toast.makeText(Login.this,"something messed up",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });


                //cp

                    startActivity(new Intent(Login.this,StudentDetailsCategory.class));
                }else{
                    Toast.makeText(Login.this,"Login Failed",Toast.LENGTH_SHORT).show();
                    counter--;
                    wrAtmt.setText("Number of attempts remaining :" + String.valueOf(counter));
                    if(counter==0)
                    {
                        login.setEnabled(false);
                    }
                }

            }
        });


    }

}


