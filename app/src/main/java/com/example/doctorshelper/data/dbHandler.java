package com.example.doctorshelper.data;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.doctorshelper.model.patient;
import com.example.doctorshelper.params.params;

import java.util.ArrayList;
import java.util.List;

public class dbHandler extends SQLiteOpenHelper{
    public dbHandler(Context context)
    {
        super(context, params.DBName,null,params.DBVersion);
    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String create = "CREATE TABLE "+params.TABLE_NAME+"("+params.KEY_ID+" INTEGER PRIMARY KEY,"+params.KEY_NAME+
                " TEXT, "+params.KEY_PHONE+" TEXT, "+params.KEY_DISEASE +" TEXT, "+ params.KEY_NEXT_APPOINTMENT + " TEXT "
                + ")";
        Log.d("tag",create);
        db.execSQL(create);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,int newVersion)
    {

    }
    public void addPatient(patient Patient)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(params.KEY_NAME,Patient.getName());
        values.put(params.KEY_PHONE,Patient.getPhoneNumber());
        values.put(params.KEY_DISEASE,Patient.getDisease());
        values.put(params.KEY_NEXT_APPOINTMENT,Patient.getNext_appointment());
        db.insert(params.TABLE_NAME,null,values);
        db.close();
    }
    public List<patient> getAllPatients()
    {
        List<patient> patientList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String select = "SELECT * FROM " + params.TABLE_NAME;
        Cursor cursor = db.rawQuery(select,null);

        if(cursor.moveToFirst())
        {
            do {
                patient Patient = new patient();
                Patient.setId(Integer.parseInt(cursor.getString(0)));
                Patient.setName(cursor.getString(1));
                Patient.setPhoneNumber(cursor.getString(2));
                Patient.setDisease(cursor.getString(3));
                Patient.setNext_appointment(cursor.getString(4));
                patientList.add(Patient);
            }while(cursor.moveToNext());

        }
        return patientList;
    }
    public int updatePatient(patient Patient)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(params.KEY_NAME,Patient.getName());
        values.put(params.KEY_PHONE,Patient.getPhoneNumber());
        values.put(params.KEY_DISEASE,Patient.getDisease());
        values.put(params.KEY_NEXT_APPOINTMENT,Patient.getNext_appointment());
        return db.update(params.TABLE_NAME,values,params.KEY_ID+"=?",new String[]{String.valueOf(Patient.getId())});
    }
    public void deletePatient(int id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(params.TABLE_NAME,params.KEY_ID+" =?",new String[]{String.valueOf(id)});
        db.close();
    }
    public void deletePatient(patient Patient)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(params.TABLE_NAME,params.KEY_ID+"?",new String[]{String.valueOf(Patient.getId())});
        db.close();
    }
    public int getCount()
    {
        String query = " SELECT * FROM "+ params.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        return cursor.getCount();
    }
}
