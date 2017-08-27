package com.example.suraj.newsread.fragments;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.suraj.newsread.R;
import com.example.suraj.newsread.models.Articles;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MyNewsRecyclerViewAdapter extends RecyclerView.Adapter<MyNewsRecyclerViewAdapter.ViewHolder> {

    private List<Articles.BaseNews> mValues;
    private final NewsFragment.OnListFragmentInteractionListener mListener;
    private Context context;

    public MyNewsRecyclerViewAdapter(Context context, List<Articles.BaseNews> items, NewsFragment.OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
        this.context = context;
    }

    public void updateList(ArrayList<Articles.BaseNews> updatedList) {
        this.mValues = updatedList;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_news, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.tv_Title.setText(holder.mItem.getTitle());
        holder.tv_Description.setText(holder.mItem.getDescription());
        holder.tv_Time.setText(holder.mItem.getPublishedAt());
        Picasso.with(context).load(holder.mItem.getUrlToImage()).placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher).into(holder.iv_image);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView tv_Title;
        public final TextView tv_Description;
        public final TextView tv_Time;
        public final ImageView iv_image;
        public Articles.BaseNews mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            tv_Title = view.findViewById(R.id.tv_title);
            tv_Description = view.findViewById(R.id.tv_desc);
            tv_Time = view.findViewById(R.id.tv_time);
            iv_image = view.findViewById(R.id.iv);
        }
    }


}
