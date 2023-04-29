package com.example.optiimind;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;
import java.util.HashMap;

public class BookAppointment extends AppCompatActivity {
    EditText nameText , NumberText, DateText, TimeText;
    Button bt1;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appointment);
        nameText = findViewById(R.id.aname);
        NumberText = findViewById(R.id.anumber);
        DateText = findViewById(R.id.adate);
        TimeText = findViewById(R.id.atime);
        bt1 = findViewById(R.id.bappoint);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameText.getText().toString();
                String number = NumberText.getText().toString();
                String date = DateText.getText().toString();
                String time = TimeText.getText().toString();
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("name", name);
                hashMap.put("number", number);
                hashMap.put("date", date);
                hashMap.put("time", time);
                databaseReference.child("Appointments").child(name).setValue(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(BookAppointment.this, "Appointment has been booked!", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(BookAppointment.this, "success", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }
}