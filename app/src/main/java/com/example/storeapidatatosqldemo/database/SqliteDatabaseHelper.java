package com.example.storeapidatatosqldemo.database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.storeapidatatosqldemo.model.TripsHistoryResp;

import java.util.ArrayList;

public class SqliteDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "upcoming.db";
    SQLiteDatabase db;

    private static final int DATABASE_VERSION = 1;
    private static final String ID = "id";
    private static final String START_TIME = "start_time";
    private static final String END_TIME = "end_time";
    private static final String STATUS = "status";
    private static final String SERVICE_TYPE = "service_type";
    private static final String START_LOCATION_CITY = "start_location_city";
    private static final String END_LOCATION_CITY = "end_location_city";
    private static final String ESTIMATED_PRICE = "estimated_price";


    public SqliteDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String q = "CREATE TABLE Upcoming (" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + START_TIME + " TEXT," + END_TIME + " TEXT,"
                + STATUS + " TEXT," + SERVICE_TYPE + " TEXT," + START_LOCATION_CITY + " TEXT," + END_LOCATION_CITY + " TEXT," + ESTIMATED_PRICE + " TEXT)";

        sqLiteDatabase.execSQL(q);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists upcoming");
        onCreate(sqLiteDatabase);
    }

    public boolean insertData(String id, String StartTime, String endTime, String status, String serviceType, String startLocationCity,
                              String endLocationCity, String estimatedPrice)
    {
        db = this.getWritableDatabase();

        ContentValues Values = new ContentValues();
        Values.put(ID, id);
        Values.put(START_TIME, StartTime);
        Values.put(END_TIME, endTime);
        Values.put(STATUS, status);
        Values.put(SERVICE_TYPE, serviceType);
        Values.put(START_LOCATION_CITY, startLocationCity);
        Values.put(END_LOCATION_CITY, endLocationCity);
        Values.put(ESTIMATED_PRICE, estimatedPrice);

        long r = this.db.insert("Upcoming", null, Values);

        if (r == -1)
            return false;
        else
            db.close();
        return true;
    }

    // we have created a new method for reading all the courses.
    @SuppressLint("Range")
    public ArrayList<TripsHistoryResp> getAllData()
    {
        // on below line we are creating a database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursor = db.rawQuery("SELECT * FROM Upcoming", null);

        // on below line we are creating a new array list.
        ArrayList<TripsHistoryResp> tripsHistoryRespList = new ArrayList<>();
        // moving our cursor to first position.
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                int id = cursor.getInt(cursor.getColumnIndex(ID));
                String start_time = cursor.getString(cursor.getColumnIndex(START_TIME));
                String end_time = cursor.getString(cursor.getColumnIndex(END_TIME));
                String status = cursor.getString(cursor.getColumnIndex(STATUS));
                String service_type = cursor.getString(cursor.getColumnIndex(SERVICE_TYPE));
                String start_location_city = cursor.getString(cursor.getColumnIndex(START_LOCATION_CITY));
                String end_location_city = cursor.getString(cursor.getColumnIndex(END_LOCATION_CITY));
                String estimated_price = cursor.getString(cursor.getColumnIndex(ESTIMATED_PRICE));

                tripsHistoryRespList.add(new TripsHistoryResp(Long.parseLong(String.valueOf(id)),start_time,end_time,status,service_type,start_location_city,end_location_city,Double.parseDouble(estimated_price)));

                cursor.moveToNext();
            }
            Log.d("TAG", "get all data from ArrayList in database" + tripsHistoryRespList);
        }
        // at last closing our cursor and returning our array list.
        cursor.close();
        return tripsHistoryRespList;
    }

    public void deleteAll()
    {
        db = this.getWritableDatabase();
        db.execSQL("DELETE FROM Upcoming");
        db.close();
    }
}

