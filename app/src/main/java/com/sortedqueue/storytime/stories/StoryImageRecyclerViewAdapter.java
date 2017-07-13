package com.sortedqueue.storytime.stories;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.sortedqueue.storytime.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Alok on 13/07/17.
 */

class StoryImageRecyclerViewAdapter extends RecyclerView.Adapter<StoryImageRecyclerViewAdapter.ViewHolder> {

    private ArrayList<String> storyImages;
    private Context context;

    public StoryImageRecyclerViewAdapter(ArrayList<String> storyImages) {
        this.storyImages = storyImages;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_story_image, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(context)
                .load(storyImages.get(position))
                .thumbnail(0.5f)
                .into(holder.storyImageView);
    }

    @Override
    public int getItemCount() {
        return storyImages.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.storyImageView)
        ImageView storyImageView;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
