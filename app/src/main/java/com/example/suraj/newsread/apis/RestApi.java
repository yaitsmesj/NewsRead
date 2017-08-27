package com.example.suraj.newsread.apis;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Suraj on 09-Aug-17.
 */
public class RestApi {

    private ArticlesApi articlesApi;
    private static RestApi restApi;
    private SourcesApi sourcesApi;

    public ArticlesApi getArticlesApi() {
        return articlesApi;
    }

    public SourcesApi getSourcesApi() {
        return sourcesApi;
    }

    private RestApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://newsapi.org")
                .addConverterFactory(
                        GsonConverterFactory.create()
                )
                .build();
        articlesApi = retrofit.create(ArticlesApi.class);
        sourcesApi = retrofit.create(SourcesApi.class);
    }

    public static RestApi getInstance() {
        if (restApi == null) {
            restApi = new RestApi();
        }
        return restApi;
    }
}
