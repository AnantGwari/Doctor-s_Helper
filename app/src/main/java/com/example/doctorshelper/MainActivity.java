package com.example.doctorshelper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import com.example.doctorshelper.adapter.RecyclerViewAdapter;
import com.example.doctorshelper.data.dbHandler;
import com.example.doctorshelper.model.patient;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerViewAdapter recycleViewAdapter;
    private ArrayList<patient> patientArrayList;
    private ArrayAdapter<String> arrayAdapter;
    public Button add,count;
    public dbHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        add = findViewById(R.id.button);
        count = findViewById(R.id.count);
        db = new dbHandler(MainActivity.this);
        patientArrayList = new ArrayList<>();
        List<patient> allPatient = db.getAllPatients();
        for(patient Patient:allPatient)
        {
            patientArrayList.add(Patient);
        }
        recycleViewAdapter = new RecyclerViewAdapter(MainActivity.this,patientArrayList);
        recyclerView.setAdapter(recycleViewAdapter);


    }
    public void count(View view)
    {
        int count = db.getCount();
        Toast.makeText(this,"Total Patients registered ="+count,Toast.LENGTH_SHORT).show();

    }
    public void onClick(View view)
    {
        Intent intent = new Intent(this,Adding.class);
        startActivity(intent);

    }
    public void onDelete(int id)
    {
        db.deletePatient(id);
        recycleViewAdapter.notifyItemRemoved(id);
    }
}