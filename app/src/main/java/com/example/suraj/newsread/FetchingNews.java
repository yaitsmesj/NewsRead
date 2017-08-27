package com.example.suraj.newsread;

import android.util.Log;

import com.example.suraj.newsread.apis.ArticlesApi;
import com.example.suraj.newsread.apis.RestApi;
import com.example.suraj.newsread.fragments.MyNewsRecyclerViewAdapter;
import com.example.suraj.newsread.models.Articles;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.suraj.newsread.MainActivity.TAG;

/**
 * Created by Suraj on 09-Aug-17.
 */

public class FetchingNews {

    @SuppressWarnings("unchecked")
    private final ArrayList<Articles.BaseNews>[] data = new ArrayList[1];
    private ArticlesApi articlesApi = RestApi.getInstance().getArticlesApi();
    private ArrayList<String> sources = new ArrayList<>();

    public void fetchNews(final MyNewsRecyclerViewAdapter myNewsRecyclerViewAdapter, int category, String source) {

        if (source == null || source.equals("")) {

            if (category == Utils.TOP_NEWS) {
                sources.add("google-news");
            } else if (category == Utils.BUSINESS) {
                sources.add("business-insider");
                sources.add("abc-news-au");
            } else if (category == Utils.TECHNOLOGY) {
                sources.add("ars-technica");
                sources.add("engadget");
            } else if (category == Utils.ENTERTAINMENT) {
                sources.add("entertainment-weekly");
                sources.add("mtv-news");
            } else if (category == Utils.SPORTS) {
                sources.add("bbc-sport");
                sources.add("talksport");
            }

        } else {
            sources.add(source);
        }
        data[0] = new ArrayList<>();
        for (int i = 0; i < sources.size(); i++) {

            articlesApi.getNews(sources.get(i), "top", "c2ec927124e043a5abc4b49dc6f4aaef").enqueue(new Callback<Articles>() {
                @Override
                public void onResponse(Call<Articles> call, Response<Articles> response) {
                    data[0].addAll(new ArrayList<>(Arrays.asList(response.body().getArticles())));
                    Log.d(TAG, "onResponse: " + data[0]);
                    myNewsRecyclerViewAdapter.updateList(data[0]);
                }

                @Override
                public void onFailure(Call<Articles> call, Throwable t) {
                    Log.d(TAG, "onFailure: ");
                }
            });
        }

    }
}
