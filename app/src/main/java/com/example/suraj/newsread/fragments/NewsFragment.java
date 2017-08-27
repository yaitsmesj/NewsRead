package com.example.suraj.newsread.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.suraj.newsread.FetchingNews;
import com.example.suraj.newsread.R;
import com.example.suraj.newsread.models.Articles;

import java.util.ArrayList;

public class NewsFragment extends Fragment {

    private static final String TAG = "Error";

    private int category = 0;
    private String source = "";
    private OnListFragmentInteractionListener mListener;

    private ArrayList<Articles.BaseNews> articles = new ArrayList<>();
    private MyNewsRecyclerViewAdapter myNewsRecyclerViewAdapter;

    public NewsFragment() {
    }


    public static NewsFragment getInstance(int category, String source) {
        NewsFragment fragment = new NewsFragment();
        Bundle args = new Bundle();
        args.putInt("CATEGORY", category);
        args.putString("SOURCE", source);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            category = getArguments().getInt("CATEGORY");
            source = getArguments().getString("SOURCE");
        }


        myNewsRecyclerViewAdapter = new MyNewsRecyclerViewAdapter(getContext(), articles, mListener);
        Log.d(TAG, "onCreate: 2");
        FetchingNews fetchingNews = new FetchingNews();
        fetchingNews.fetchNews(myNewsRecyclerViewAdapter, category, source);
        Log.d(TAG, "onCreate:3 " + articles);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();

            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));

            recyclerView.setAdapter(myNewsRecyclerViewAdapter);

        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(Articles.BaseNews article);
    }
}
