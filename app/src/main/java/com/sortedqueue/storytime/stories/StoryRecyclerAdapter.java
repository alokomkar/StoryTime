package com.sortedqueue.storytime.stories;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.sortedqueue.storytime.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Alok Omkar on 2017-07-07.
 */

public class StoryRecyclerAdapter extends RecyclerView.Adapter<StoryRecyclerAdapter.ViewHolder> {

    private ArrayList<Story> stories;
    private AdapterClickListener adapterClickListener;
    private Context context;

    public StoryRecyclerAdapter(ArrayList<Story> storyList, AdapterClickListener adapterClickListener) {
        this.stories = storyList;
        this.adapterClickListener = adapterClickListener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_story, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Story story = getItemAtPosition(position);
        holder.titleTextView.setText(story.getStoryName());
        holder.subTitleTextView.setText(story.getStoryType());
        Glide.with(context)
                .load(story.getStoryImage())
                .thumbnail(0.5f)
                .into(holder.storyImageView);

    }

    public Story getItemAtPosition( int position ) {
        return stories.get(position);
    }

    @Override
    public int getItemCount() {
        return stories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.storyImageView)
        ImageView storyImageView;
        @BindView(R.id.slideImageLayout)
        FrameLayout slideImageLayout;
        @BindView(R.id.titleTextView)
        TextView titleTextView;
        @BindView(R.id.subTitleTextView)
        TextView subTitleTextView;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            if( position != RecyclerView.NO_POSITION )
                adapterClickListener.onItemClick(position);
        }
    }

}
