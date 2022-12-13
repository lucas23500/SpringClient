package com.example.springclient.retrofit;

import com.example.springclient.model.Tarefa;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface TarefaApi {

    @GET("/api/tarefa")
    Call<List<Tarefa>> getAllTarefa();


    @POST("/api/tarefa")
    Call<Void> save(@Body Tarefa tarefa);




}
