package com.example.doctorshelper.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doctorshelper.MainActivity;
import com.example.doctorshelper.R;
import com.example.doctorshelper.data.dbHandler;
import com.example.doctorshelper.helper;
import com.example.doctorshelper.model.patient;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private Context context;
    private List<patient> patientList;
    private helper listener;
    public int patientId;
    public dbHandler db;

    public RecyclerViewAdapter(Context context, List<patient> patientList) {
        this.context = context;
        this.patientList = patientList;
        db = new dbHandler(context);
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        patient Patient = patientList.get(position);
        patientId = Patient.getId();
        Log.d("tag","fwf"+patientId+" "+holder.getAbsoluteAdapterPosition());
        holder.name.setText(Patient.getName());
        holder.phone.setText(Patient.getPhoneNumber());
        holder.disease.setText(Patient.getDisease());
        holder.appointment.setText(Patient.getNext_appointment());
        holder.del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.deletePatient(patientId);
                patientList = db.getAllPatients();
                notifyDataSetChanged();
            }
        });

    }

    public int getItemCount() {
        return patientList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView name, phone, disease, appointment;
        public ImageView imageView;
        public Button del;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            name = itemView.findViewById(R.id.name);
            phone = itemView.findViewById(R.id.phone);
            disease = itemView.findViewById(R.id.disease);
            appointment = itemView.findViewById(R.id.appointment);
            imageView = itemView.findViewById(R.id.imageView);
            del = itemView.findViewById(R.id.del);

        }

        @Override
        public void onClick(View view) {


        }
    }
}
