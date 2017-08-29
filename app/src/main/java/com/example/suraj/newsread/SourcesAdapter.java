package com.example.suraj.newsread;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.suraj.newsread.models.Sources;

import java.util.ArrayList;


public class SourcesAdapter extends RecyclerView.Adapter<SourcesAdapter.SourcesViewHolder> {

    private final Context context;
    private ArrayList<Sources.SourceData> sourcesList;
    private SourceSelectListener sourceSelectListener;

    interface SourceSelectListener {
        void onSourceSelected(Sources.SourceData sourceItem);
    }

    public void setOnSourceSelectedListener(SourceSelectListener sourceSelectedListener) {
        this.sourceSelectListener = sourceSelectedListener;
    }

    public SourcesAdapter(Context context, ArrayList<Sources.SourceData> sourcesList) {
        this.context = context;
        this.sourcesList = sourcesList;
    }

    public void updateList(ArrayList<Sources.SourceData> sourcesList) {
        this.sourcesList = sourcesList;
        notifyDataSetChanged();
    }

    @Override
    public SourcesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(parent.getContext());
        View view = li.inflate(R.layout.activity_source_list_item, parent, false);
        return new SourcesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SourcesViewHolder holder, int position) {

        final Sources.SourceData item = sourcesList.get(position);
        holder.sourceName.setText(item.getName());
        holder.sourceCategory.setText(item.getCategory());
//        Picasso.with(context).load(item.getUrlsToLogos().getMedium()).placeholder(R.mipmap.ic_launcher)
//                .error(R.mipmap.ic_launcher).into(holder.sourceLogo);

        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sourceSelectListener.onSourceSelected(item);
            }
        });

    }

    @Override
    public int getItemCount() {
        return sourcesList.size();
    }

    class SourcesViewHolder extends RecyclerView.ViewHolder {


        public final View rootView;
        public final TextView sourceName;
        public final TextView sourceCategory;
        public final ImageView sourceLogo;

        public SourcesViewHolder(View itemView) {
            super(itemView);
            rootView = itemView;
            sourceName = itemView.findViewById(R.id.tv_SourceName);
            sourceCategory = itemView.findViewById(R.id.tv_Category);
            sourceLogo = itemView.findViewById(R.id.iv_source);

        }

    }
}
