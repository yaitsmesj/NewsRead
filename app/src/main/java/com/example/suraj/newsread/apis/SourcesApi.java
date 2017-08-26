package com.example.suraj.newsread.apis;

import com.example.suraj.newsread.models.Sources;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Suraj on 19-Aug-17.
 */

public interface SourcesApi {

    @GET("/v1/sources")
    Call<Sources> getSources(
            @Query("language") String language
    );
}
