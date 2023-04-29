package com.example.optiimind;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Registration extends AppCompatActivity {
    FirebaseAuth mAuth;
    FirebaseUser mUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
         mAuth = FirebaseAuth.getInstance();
         mUser = mAuth.getCurrentUser();
        EditText emailText = findViewById(R.id.emailL);
        EditText passwordText = findViewById(R.id.passwordL);

        Button btn = findViewById(R.id.loginButton);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailText.getText().toString();
                String password = passwordText.getText().toString();
                if(password.isEmpty()){
                    passwordText.setError("enter the password");
                }else if(email.isEmpty()){
                    emailText.setError("enter the email");

                }else{
                   mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                       @Override
                       public void onComplete(@NonNull Task<AuthResult> task) {
                           if(task.isSuccessful()){
                               sendUserToLogin();
                               Toast.makeText(Registration.this, "Registration Successfull", Toast.LENGTH_SHORT);

                           }
                           else{
                               Toast.makeText(Registration.this, "Registration Unsuccessfull", Toast.LENGTH_SHORT);
                           }
                       }
                   });
                }

            }

            private void sendUserToLogin() {
                Intent intent = new Intent(Registration.this, login.class);
                startActivity(intent);
            }
        });


    }
}