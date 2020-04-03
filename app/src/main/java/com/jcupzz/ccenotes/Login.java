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
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    private EditText name;
    private EditText pass;
    private Button login;
    private int counter=5;
    private TextView wrAtmt;
    private FirebaseAuth firebaseAuth;

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


    private void validate(String userName,String userPass)
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
                    Toast.makeText(Login.this,"Login succesfull",Toast.LENGTH_SHORT).show();
                    StudentTeacherCategory.stc_integer=2;
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


