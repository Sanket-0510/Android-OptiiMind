package com.example.optiimind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class YourAppointments extends AppCompatActivity {
    Button bt;
    TextView t1,t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_appointments);
        bt = findViewById(R.id.buttonyp);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String number = intent.getStringExtra("number");
        String date = intent.getStringExtra("date");
        String time = intent.getStringExtra("time");
        t1 = findViewById(R.id.username);
        t2 = findViewById(R.id.bookinfo);
        t1.setText(":"+name);
        t2.setText("Appointment Booked on "+ date + "\nTime of appointment is "+ time);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open1();
            }
        });
    }

    private void open1() {
        Intent intent = new Intent(YourAppointments.this,MainActivity.class);
        startActivity(intent);


    }
}