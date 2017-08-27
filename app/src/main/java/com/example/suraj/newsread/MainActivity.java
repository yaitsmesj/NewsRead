package com.example.suraj.newsread;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.suraj.newsread.fragments.NewsFragment;
import com.example.suraj.newsread.models.Articles;

public class MainActivity extends AppCompatActivity
        implements NewsFragment.OnListFragmentInteractionListener {

    public static final String TAG = "Error";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager()));
        viewPager.setOffscreenPageLimit(2);
        Log.d(TAG, "onCreate:1 ");

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.newspapers) {
            Intent intent = new Intent(this, SourcesActivity.class);
            startActivity(intent);
        } else if (id == R.id.about) {

        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onListFragmentInteraction(Articles.BaseNews article) {

    }
}
