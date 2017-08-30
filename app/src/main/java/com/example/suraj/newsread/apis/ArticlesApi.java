package com.example.suraj.newsread.apis;

import com.example.suraj.newsread.models.Articles;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;



public interface ArticlesApi {
    @GET("/v1/articles")
    Call<Articles> getNews(
            @Query("source") String source,
            @Query("sortBy") String sort,
            @Query("apiKey") String key
    );
}
