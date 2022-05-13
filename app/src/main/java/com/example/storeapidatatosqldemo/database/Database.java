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

public class Database extends SQLiteOpenHelper {

    private static final String dbname = "upcoming.db";
    SQLiteDatabase db;

    private static final String ID = "idDb";
    private static final String START_TIME = "startTimeDb";
    private static final String END_TIME = "endTimeDb";
    private static final String STATUS = "statusDb";
    private static final String SERVICE_TYPE = "serviceTypeDb";
    private static final String START_LOCATION_CITY = "startLocationCityDb";
    private static final String END_LOCATION_CITY = "endLocationCityDb";
    private static final String ESTIMATED_PRICE = "estimatedPriceDb";


    public Database(@Nullable Context context) {
        super(context, dbname, null, 4);
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
        /*public boolean insertData(String idDb,String startLocationCityDb , String endLocationCityDb) */ {

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
    public ArrayList<TripsHistoryResp> getAllData() {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorCourses = db.rawQuery("SELECT * FROM Upcoming", null);

        // on below line we are creating a new array list.
        ArrayList<TripsHistoryResp> courseModalArrayList = new ArrayList<>();
        // moving our cursor to first position.
        if (cursorCourses.moveToFirst()) {

            while (!cursorCourses.isAfterLast()) {

                int id = cursorCourses.getInt(cursorCourses.getColumnIndex(ID));
                String start_time =  cursorCourses.getString(cursorCourses.getColumnIndex(START_TIME));
                String end_time =  cursorCourses.getString(cursorCourses.getColumnIndex(END_TIME));
                String status =  cursorCourses.getString(cursorCourses.getColumnIndex(STATUS));
                String service_type =  cursorCourses.getString(cursorCourses.getColumnIndex(SERVICE_TYPE));
                String start_location_city =  cursorCourses.getString(cursorCourses.getColumnIndex(START_LOCATION_CITY));
                String end_location_city =  cursorCourses.getString(cursorCourses.getColumnIndex(END_LOCATION_CITY));
                String estimated_price=  cursorCourses.getString(cursorCourses.getColumnIndex(ESTIMATED_PRICE));


                courseModalArrayList.add(new TripsHistoryResp(Long.parseLong(String.valueOf(id)),start_time,end_time,status,service_type,start_location_city,end_location_city,Double.parseDouble(estimated_price)));

                cursorCourses.moveToNext();
            }
            Log.d("TAG", "get all data from ArrayList in database" + courseModalArrayList);
        }
        // at last closing our cursor
        // and returning our array list.
        cursorCourses.close();
        return courseModalArrayList;
    }

    public void deleteAll() {
        db = this.getWritableDatabase();
        db.execSQL("DELETE FROM Upcoming");
        db.close();
    }


}

