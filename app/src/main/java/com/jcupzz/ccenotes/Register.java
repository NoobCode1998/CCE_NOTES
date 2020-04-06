package com.jcupzz.ccenotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.firestore.DocumentSnapshot;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {
    public static final String TAG = "TAG";
    EditText mEmail, mPassword, mAccess;
    Button mRegisterBtn;
    TextView mLoginBtn;
    FirebaseAuth fAuth;
    ProgressBar progressBar;
    static String userID,staffAccess,StdAccess;
    static int prevChoice;
    SharedPreferences sharedpreferences;


    FirebaseFirestore db = FirebaseFirestore.getInstance();
    //FirebaseDatabase db = FirebaseDatabase.getInstance();
    String staff = "-1";






    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        mEmail = findViewById(R.id.Email);
        mPassword = findViewById(R.id.password);
        mAccess = findViewById(R.id.access);
        mRegisterBtn = findViewById(R.id.registerBtn);
        mLoginBtn = findViewById(R.id.createText);

        fAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressBar);






        if (fAuth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), StudentDetailsCategory.class));
            finish();
        }


        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = mEmail.getText().toString().trim();
                final String password = mPassword.getText().toString().trim();
                final String Access = mAccess.getText().toString();


                //      Toast.makeText(Register.this, "students"+StdAccess+"\n staff "+staffAccess, Toast.LENGTH_SHORT).show();

//                if(!((Access.equals("A1B2C4"))||Access.equals("12345"))){
//                    mAccess.setError("the access code entered isnt for staff");
//                    staff="1";
//                    return;
//                }

//                DocumentReference docRef = db.collection("roles").document("AccessCode");
//                docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
//                    @Override
//                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
//                        if (task.isSuccessful()) {
//                            DocumentSnapshot document = task.getResult();
//                            if (document != null) {
//                                staffAccess = (document.getString("StaffCCE"));
//                                StdAccess = (document.getString("StudentCCE"));
//
//
//                            }
//                        }
//                    }
//                });

                if(Access.equals(staffAccess)){
                    staff="1";
                }
                else if(Access.equals(StdAccess)){
                    staff="0";
                }
                else{
                    mAccess.setError("Access code is wrong");
                    return;
                }



                if (TextUtils.isEmpty(email)) {
                    mEmail.setError("Email is Required.");
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    mPassword.setError("Password is Required.");
                    return;
                }

                if (password.length() < 6) {
                    mPassword.setError("Password Must be >= 6 Characters");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                // register the user in firebase

                fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {


                            Toast.makeText(Register.this, "User Created.", Toast.LENGTH_SHORT).show();
                            userID = fAuth.getCurrentUser().getUid();


                            /////cp

                            role roles = new role(userID, email, staff, password);

                            db.collection("roles")
                                    .document(email).set(roles)
                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            Toast.makeText(getApplicationContext(), "Successfully Registered", Toast.LENGTH_SHORT).show();
                                            if (staff.equals("1")) {
                                                //user shared preferecnce start

                                                sharedpreferences = getSharedPreferences("loginSave",
                                                        MODE_PRIVATE);
                                                SharedPreferences.Editor myEdit = sharedpreferences.edit();
                                                myEdit.putString("name",userID);
                                                myEdit.putString("pass",password);
                                                myEdit.putString("staff",staff);
                                                myEdit.commit();


                                                startActivity(new Intent(getApplicationContext(), StudentDetailsCategory.class));
                                                //finish();
                                                //finish();


                                                //user shared preference
                                                Toast.makeText(getApplicationContext(), "Registered as staff", Toast.LENGTH_SHORT).show();
                                            }else {
                                                sharedpreferences = getSharedPreferences("loginSave",
                                                        MODE_PRIVATE);
                                                SharedPreferences.Editor myEdit = sharedpreferences.edit();
                                                myEdit.putString("name",userID);
                                                myEdit.putString("pass",password);
                                                myEdit.putString("staff",staff);
                                                myEdit.commit();


                                                startActivity(new Intent(getApplicationContext(), StudentDetailsCategory.class));
                                                //finish();

                                                Toast.makeText(getApplicationContext(), "Registered as student", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();

                                        }
                                    });


                            /////cp





                        }else {
                            Toast.makeText(Register.this, "Error ! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });
            }
        });


        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Login.class));
                //finish();

            }
        });

    }
}














