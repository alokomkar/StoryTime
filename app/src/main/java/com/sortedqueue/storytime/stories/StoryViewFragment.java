package com.sortedqueue.storytime.stories;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sortedqueue.storytime.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Alok on 12/07/17.
 */

public class StoryViewFragment extends Fragment {

    private static StoryViewFragment instance;

    @BindView(R.id.storyImageRecyclerView)
    RecyclerView storyImageRecyclerView;
    @BindView(R.id.storyTextView)
    TextView storyTextView;

    private SubStories story;
    private String TAG = StoryListFragment.class.getSimpleName();

    private StoryNavigationListener storyNavigationListener;

    public static StoryViewFragment getInstance() {
        if (instance == null)
            instance = new StoryViewFragment();
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_story_view, container, false);
        ButterKnife.bind(this, fragmentView);
        setHasOptionsMenu(true);
        storyTextView.setText(story.getStoryContent());
        setupAdapter();
        return fragmentView;
    }

    private void setupAdapter() {
        storyImageRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        storyImageRecyclerView.setAdapter(new StoryImageRecyclerViewAdapter(story.getStoryImages()));
        final GravitySnapHelper gravitySnapHelper = new GravitySnapHelper(Gravity.START);
        gravitySnapHelper.attachToRecyclerView(storyImageRecyclerView);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof StoryNavigationListener) {
            storyNavigationListener = (StoryNavigationListener) context;
        }
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

    public void setSubStory(SubStories story) {
        this.story = story;
    }

}