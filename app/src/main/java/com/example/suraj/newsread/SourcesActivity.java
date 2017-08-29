package com.example.suraj.newsread;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.suraj.newsread.apis.RestApi;
import com.example.suraj.newsread.apis.SourcesApi;
import com.example.suraj.newsread.models.Sources;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SourcesActivity extends AppCompatActivity
        implements SourcesAdapter.SourceSelectListener {

    private static final String TAG = "Error";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sources);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_Sources);
        final SourcesAdapter sourcesAdapter = new SourcesAdapter(this, new ArrayList<Sources.SourceData>());

        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(sourcesAdapter);

        SourcesApi sourcesApi = RestApi.getInstance().getSourcesApi();
        sourcesApi.getSources().enqueue(new Callback<Sources>() {
            @Override
            public void onResponse(@NonNull Call<Sources> call, @NonNull Response<Sources> response) {
                Log.d(TAG, "onResponse: " + response.body());
                sourcesAdapter.updateList(new ArrayList<>(Arrays.asList(response.body().getSources())));
            }

            @Override
            public void onFailure(@NonNull Call<Sources> call, @NonNull Throwable t) {
                Log.d(TAG, "onFailure: ");
            }
        });

        sourcesAdapter.setOnSourceSelectedListener(this);
    }

    @Override
    public void onSourceSelected(Sources.SourceData sourceItem) {

        Intent intent = new Intent(this, SourceNewsActivity.class);
        intent.putExtra("SOURCE", sourceItem.getId());
        startActivity(intent);

    }
}
