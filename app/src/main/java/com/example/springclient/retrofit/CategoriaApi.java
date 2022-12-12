package com.example.springclient.retrofit;

import com.example.springclient.model.Categoria;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;

public interface CategoriaApi {

    @GET("/api/categoria")
    Call<List<Categoria>> getAllCategorias();





    @POST("/api/categoria")
    Call<Void> save(@Body Categoria categoria);



}
