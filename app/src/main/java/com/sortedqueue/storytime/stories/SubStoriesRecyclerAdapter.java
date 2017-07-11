package com.sortedqueue.storytime.stories;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sortedqueue.storytime.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Alok on 11/07/17.
 */

public class SubStoriesRecyclerAdapter extends RecyclerView.Adapter<SubStoriesRecyclerAdapter.ViewHolder> {

    private Context context;
    private ArrayList<SubStories> subStories;
    private AdapterClickListener adapterClickListener;

    public SubStoriesRecyclerAdapter(ArrayList<SubStories> subStories, AdapterClickListener adapterClickListener) {
        this.subStories = subStories;
        this.adapterClickListener = adapterClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_sub_story, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        SubStories story = getItemAtPosition(position);
        holder.titleTextView.setText(story.getStoryName());
        Glide.with(context)
                .load(story.getStoryImages().get(0))
                .thumbnail(0.5f)
                .into(holder.storyImageView);

    }

    private SubStories getItemAtPosition(int position) {
        return subStories.get(position);
    }

    @Override
    public int getItemCount() {
        return subStories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.storyImageView)
        ImageView storyImageView;
        @BindView(R.id.titleTextView)
        TextView titleTextView;
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
