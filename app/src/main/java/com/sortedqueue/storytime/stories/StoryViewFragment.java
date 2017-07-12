package com.sortedqueue.storytime.stories;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sortedqueue.storytime.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Alok on 12/07/17.
 */

public class StoryViewFragment extends Fragment {

    private static StoryViewFragment instance;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbar_layout)
    CollapsingToolbarLayout toolbarLayout;
    @BindView(R.id.app_bar)
    AppBarLayout appBar;
    @BindView(R.id.storyImageView)
    ImageView storyImageView;
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
        Glide.with(getContext())
                .load(story.getStoryImages().get(0))
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
        storyTextView.setText(story.getStoryContent());
        return fragmentView;
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