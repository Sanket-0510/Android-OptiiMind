package com.example.optiimind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class YourAppointments extends AppCompatActivity {
    Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_appointments);
        bt = findViewById(R.id.homeopen);
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