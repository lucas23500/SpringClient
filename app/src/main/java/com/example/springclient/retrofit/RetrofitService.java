package com.example.springclient.retrofit;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.StringReader;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    private Retrofit retrofit;





    public RetrofitService() {
        initializeRetrofit();
    }

    private void initializeRetrofit(){

        retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.112:9000")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();

    }



    public Retrofit getRetrofit(){
        return retrofit;
    }
}
