package com.sortedqueue.storytime.stories;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.sortedqueue.storytime.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Alok Omkar on 2017-07-09.
 */

public class StoryListFragment extends Fragment implements AdapterClickListener {

    private static StoryListFragment instance;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbar_layout)
    CollapsingToolbarLayout toolbarLayout;
    @BindView(R.id.app_bar)
    AppBarLayout appBar;
    @BindView(R.id.storyImageView)
    ImageView storyImageView;
    @BindView(R.id.storyRecylerView)
    RecyclerView storyRecylerView;
    private Story story;
    private String TAG = StoryListFragment.class.getSimpleName();

    public static StoryListFragment getInstance() {
        if (instance == null)
            instance = new StoryListFragment();
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_story_list, container, false);
        ButterKnife.bind(this, fragmentView);
        setHasOptionsMenu(true);
        Glide.with(getContext())
                .load(story.getStoryImage())
                .thumbnail(0.5f)
                .into(storyImageView);
        toolbar.setTitle(story.getStoryName());
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });
        toolbar.setNavigationIcon(R.drawable.ic_back_arrow);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });
        setupRecyclerView();
        return fragmentView;
    }

    private void setupRecyclerView() {
        storyRecylerView.setLayoutManager(new LinearLayoutManager(getContext()));
        storyRecylerView.setAdapter(new SubStoriesRecyclerAdapter(story.getSubStories(), this));
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                getActivity().onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void setStory(Story story) {
        this.story = story;
    }


    @Override
    public void onItemClick(int position) {

    }
}
