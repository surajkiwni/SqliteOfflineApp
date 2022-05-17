package com.example.storeapidatatosqldemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.storeapidatatosqldemo.database.SqliteDatabaseHelper;
import com.example.storeapidatatosqldemo.model.AppConstants;
import com.example.storeapidatatosqldemo.model.TripsHistoryResp;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView upcomingRecyclerView;
    UpcomingAdapter upcomingAdapter;
    List<TripsHistoryResp> tripHistoryList = new ArrayList<>();
    List<TripsHistoryResp> tripHistoryListDb = new ArrayList<>();
    String TAG = this.getClass().getSimpleName();
    int partyId = 532;
    Boolean check = false;
    String startLocationCity = "", endLocationCity = "", serviceType = "",
            startTime = "", endTime = "", status = "", id1 = "", estimatedPrice = "";
    TripsHistoryResp tripListResp;
    SqliteDatabaseHelper sqliteDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        upcomingRecyclerView = findViewById(R.id.upcomingRecyclerView);

        Log.d(TAG, "partyId = " + partyId);

        sqliteDatabaseHelper = new SqliteDatabaseHelper(this);

        if (isNetworkConnected()) {
            /* call trip history api */
            getTripHistoryData(partyId);
        } else {
            tripHistoryListDb = sqliteDatabaseHelper.getAllData();
            upcomingRecyclerView.setHasFixedSize(true);
            upcomingRecyclerView.setLayoutManager(new GridLayoutWrapper(MainActivity.this, 1));
            upcomingAdapter = new UpcomingAdapter(MainActivity.this, tripHistoryListDb);
            upcomingRecyclerView.setAdapter(upcomingAdapter);
            Log.d("TAG", "database value " + tripHistoryListDb);
        }

    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }


    public void getTripHistoryData(int id) {
        Log.d(TAG, "id = " + id);

        ApiInterface apiInterface = ApiClient.getClient(AppConstants.BASE_URL).create(ApiInterface.class);
        Call<List<TripsHistoryResp>> listCall = apiInterface.getUpcomingTripHistory(id, "In-Progress");

        listCall.enqueue(new Callback<List<TripsHistoryResp>>() {
            @Override
            public void onResponse(Call<List<TripsHistoryResp>> call, Response<List<TripsHistoryResp>> response) {
                int statusCode = response.code();
                Log.d(TAG, "code = " + statusCode);
                Log.d(TAG, "response = " + response.toString());

                if (statusCode == 200) {
                    if (response.body().size() == 0) {
                        //array is empty
                        Toast.makeText(MainActivity.this, "Trips are Not Available", Toast.LENGTH_SHORT).show();
                    } else {
                        tripHistoryList = response.body();
                        Log.d(TAG, "size = " + tripHistoryList.size());
                        Log.d(TAG, " trip History data" + tripHistoryList.toString());

                        /* delete all records*/
                        sqliteDatabaseHelper.deleteAll();

                        for (int i = 0; i < tripHistoryList.size(); i++) {
                            tripListResp = tripHistoryList.get(i);

                            id1 = tripListResp.getReservationId().toString();
                            startLocationCity = tripListResp.getStartLocationCity();
                            endLocationCity = tripListResp.getEndlocationCity();
                            serviceType = tripListResp.getServiceType();
                            startTime = tripListResp.getStartTime();
                            endTime = tripListResp.getEndTime();
                            status = tripListResp.getStatus();
                            estimatedPrice = tripListResp.getEstimatedPrice().toString();

                            /* insert new records*/
                            check = sqliteDatabaseHelper.insertData(id1, startTime, endTime, status, serviceType, startLocationCity, endLocationCity, estimatedPrice);
                        }

                        if (check) {
                            Toast.makeText(MainActivity.this, "Successful", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, "unSuccessful", Toast.LENGTH_SHORT).show();
                        }
                        Log.d(TAG, "start location City = " + startTime);
                        Log.d(TAG, "end Location City = " + tripListResp.getEndlocationCity());


                        upcomingRecyclerView.setHasFixedSize(true);
                        upcomingRecyclerView.setLayoutManager(new GridLayoutWrapper(MainActivity.this, 1));
                        upcomingAdapter = new UpcomingAdapter(MainActivity.this, tripHistoryList);
                        upcomingRecyclerView.setAdapter(upcomingAdapter);
                    }
                }

            }

            @Override
            public void onFailure(Call<List<TripsHistoryResp>> call, Throwable t) {
                Log.d(TAG, "error = " + t.toString());
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}