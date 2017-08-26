package com.example.suraj.newsread;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.suraj.newsread.fragments.NewsFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Suraj on 09-Aug-17.
 */

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private int fragCount = 0;
    List<Fragment> fragList;
    public MyFragmentPagerAdapter(FragmentManager fm,int count) {
        super(fm);
        fragCount = count;
        this.fragList = new ArrayList<>(count);
    }

    @Override
    public Fragment getItem(int position) {

        Fragment fragment;

        try{
            fragment = fragList.get(position);
        }catch (IndexOutOfBoundsException e){

            fragment = createFragment(position);
            fragList.add(position,fragment);
        }

        if(fragment==null) {
            fragment = createFragment(position);
            fragList.set(position, fragment);
        }
            return fragment;
    }

    @Override
    public int getCount() {
        return fragCount;
    }

    private Fragment createFragment(int position){

        Fragment fragment;
        if(position==Utils.BUSINESS_POSITION){
            fragment = NewsFragment.getInstance(Utils.BUSINESS,"");
        }else
        if(position==Utils.SPORTS_POSITION){
            fragment = NewsFragment.getInstance(Utils.SPORTS,"");
        }else
        if(position==Utils.ENTERTAINMENT_POSITION){
            fragment = NewsFragment.getInstance(Utils.ENTERTAINMENT,"");
        }else
        if(position==Utils.TECHNOLOGY_POSITION){
            fragment = NewsFragment.getInstance(Utils.TECHNOLOGY,"");
        }else
        {
            fragment = NewsFragment.getInstance(Utils.TOP_NEWS,"");
        }
        return fragment;
    }
}