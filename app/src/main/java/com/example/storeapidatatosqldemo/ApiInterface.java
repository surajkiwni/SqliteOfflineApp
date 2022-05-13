package com.example.storeapidatatosqldemo;

import com.example.storeapidatatosqldemo.model.TripsHistoryResp;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterface {

    String GOOGLE_MAP_API_KEY = "AIzaSyCC3Tk24iI-IU8SvXkzDUj2i2mBeFjw3-s";
    String FIREBASE_API_KEY = "AIzaSyCPVjcxB3zcRWeT35k3876rhTL0lyUWFS0";

   /* @POST("/projection/api/schedules/map/")
    Call<Map<String, Map<String, Map<String, List<ScheduleMapResp>>>>>
    getProjectionScheduleDates(@Body ScheduleDates scheduleDatesModel,
                               @Header("Authorization") String authHeader);

    @POST("/reservation/api/reservations/")
    Call<RideReservationResp>
    createRide(@Body RideReservationReq reservationReq,
               @Header("Authorization") String header);*/

    @GET("/trip/api/trips/user/{id}/{status}")
    Call<List<TripsHistoryResp>> getUpcomingTripHistory(@Path("id") int id, @Path("status") String status);

    @GET("/trip/api/trips/user/{id}/")
    Call<List<TripsHistoryResp>> getPastTripHistory(@Path("id") int id);
}
