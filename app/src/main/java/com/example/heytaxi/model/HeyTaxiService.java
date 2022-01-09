package com.example.heytaxi.model;

import java.time.LocalDateTime;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface HeyTaxiService {
    @GET("/")
    Call<LocalDateTime> serverConnect();

    @POST("/verify/request")
    Call<String> verifyReq();

    @GET("/verify")
    Call<String> verify();
}
