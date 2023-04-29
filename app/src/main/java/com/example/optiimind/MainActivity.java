package com.example.optiimind;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    Button button1, button2, button3,button4;
    LinearLayout linearLayout;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button2 = findViewById(R.id.appointment);




        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAppoint();
            }
        });


         button4 = findViewById(R.id.buttonlogin);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPage();
            }
        });

        button3 = findViewById(R.id.registrationintent);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLoginPage();
            }
        });
    }

    private void openAppoint() {
        Intent intent = new Intent(MainActivity.this, BookAppointment.class);
        startActivity(intent);
    }

    private void openPage() {
        Intent intent = new Intent(MainActivity.this, login.class);
        startActivity(intent);
    }

    private void openLoginPage() {
        Intent intent = new Intent(MainActivity.this, login.class);
        startActivity(intent);
    }
}
