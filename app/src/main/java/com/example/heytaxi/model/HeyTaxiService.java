package com.example.heytaxi.model;

import java.time.LocalDateTime;

import retrofit2.Call;
import retrofit2.http.GET;

public interface HeyTaxiService {
    @GET("/")
    Call<LocalDateTime> serverConnect();
}
