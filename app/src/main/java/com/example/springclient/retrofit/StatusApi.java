package com.example.springclient.retrofit;

import com.example.springclient.model.Categoria;
import com.example.springclient.model.Status;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface StatusApi {

    @GET("/api/status")
    Call<List<Status>> getAllStatus();


    @POST("/api/status")
    Call<Void> save(@Body Status status);



}
