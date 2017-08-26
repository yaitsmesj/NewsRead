package com.example.suraj.newsread;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;

import com.example.suraj.newsread.fragments.NewsFragment;
import com.example.suraj.newsread.models.Articles;

public class SourceNewsActivity extends AppCompatActivity implements NewsFragment.OnListFragmentInteractionListener{

    public static final String TAG = "Error";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_source_news);

        String source = getIntent().getStringExtra("SOURCE");
        Log.d(TAG, "onCreate: SourceNewsAcitvity");
        Fragment fragment = NewsFragment.getInstance(0,source);
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_Container,fragment).commit();

    }

    @Override
    public void onListFragmentInteraction(Articles.BaseNews article) {
        Log.d(TAG, "onListFragmentInteraction: ");
    }
}
