package com.example.doctorshelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doctorshelper.data.dbHandler;
import com.example.doctorshelper.model.patient;

public class Adding extends AppCompatActivity {

private TextView name,phone,disease,appoint;
private EditText name1,phone1,disease1,appoint1;
private Button add;
public patient newPatient;
public dbHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding);
        name = findViewById(R.id.name1);
        phone = findViewById(R.id.phone1);
        disease = findViewById(R.id.disease1);
        appoint = findViewById(R.id.appoint1);
        name1 = findViewById(R.id.personName);
        add = findViewById(R.id.button2);
        phone1 = findViewById(R.id.personPhone);
        disease1 = findViewById(R.id.personDisease);
        appoint1 = findViewById(R.id.personAppoint);
        db = new dbHandler(this);
    }
    public void Click(View view)
    {
        newPatient = new patient();
        newPatient.setName(name1.getText().toString());
        newPatient.setPhoneNumber(phone1.getText().toString());
        newPatient.setDisease(disease1.getText().toString());
        newPatient.setNext_appointment(appoint1.getText().toString());
        name1.setVisibility(View.INVISIBLE);
        phone1.setVisibility(View.INVISIBLE);
        disease1.setVisibility(View.INVISIBLE);
        appoint1.setVisibility(View.INVISIBLE);
        db.addPatient(newPatient);
        Toast.makeText(this,"Patient Added Successfully:",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}