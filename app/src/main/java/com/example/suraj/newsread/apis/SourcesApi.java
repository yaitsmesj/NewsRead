package com.example.suraj.newsread.apis;

import com.example.suraj.newsread.models.Sources;

import retrofit2.Call;
import retrofit2.http.GET;


public interface SourcesApi {

    @GET("/v1/sources")
    Call<Sources> getSources(
    );
}
