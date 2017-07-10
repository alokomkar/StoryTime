package com.sortedqueue.storytime.stories;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sortedqueue.storytime.R;
import com.sortedqueue.storytime.StoryActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Alok Omkar on 2017-07-08.
 */

public class StoryFragment extends Fragment implements AdapterClickListener {

    @BindView(R.id.storiesRecyclerView)
    RecyclerView storiesRecyclerView;

    private StaggeredGridLayoutManager staggeredGridLayoutManager;
    private StoryRecyclerAdapter storyRecyclerAdapter;

    private StoryNavigationListener storyNavigationListener;

    private static StoryFragment instance;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_stories, container, false);
        ButterKnife.bind(this, fragmentView);
        setupRecyclerView();
        return fragmentView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if( context instanceof StoryNavigationListener ) {
            storyNavigationListener = (StoryNavigationListener) context;
        }
    }

    private void setupRecyclerView() {

        staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        storiesRecyclerView.setLayoutManager(staggeredGridLayoutManager);
        storyRecyclerAdapter = new StoryRecyclerAdapter(Story.getStoryList(), this);
        storiesRecyclerView.setAdapter(storyRecyclerAdapter);
    }

    @Override
    public void onItemClick(int position) {
        Story story = storyRecyclerAdapter.getItemAtPosition(position);
        storyNavigationListener.loadStoryList(story);
    }

    public static Fragment getInstance() {
        if( instance == null )
            instance = new StoryFragment();
        return instance;
    }
}
