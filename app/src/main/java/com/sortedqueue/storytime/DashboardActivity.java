package com.sortedqueue.storytime;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.sortedqueue.storytime.stories.Story;
import com.sortedqueue.storytime.stories.StoryFragment;
import com.sortedqueue.storytime.stories.StoryListFragment;
import com.sortedqueue.storytime.stories.StoryNavigationListener;
import com.sortedqueue.storytime.stories.StoryViewFragment;
import com.sortedqueue.storytime.stories.SubStories;

import butterknife.ButterKnife;

public class DashboardActivity extends AppCompatActivity implements StoryNavigationListener {


    private String currentTag;
    private FragmentTransaction mFragmentTransaction;
    private Story story;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ButterKnife.bind(this);
        loadStories();
    }

    @Override
    public void loadStories() {
        currentTag = "Story";
        mFragmentTransaction = getSupportFragmentManager().beginTransaction();
        mFragmentTransaction.replace(R.id.container, StoryFragment.getInstance(), StoryFragment.class.getSimpleName());
        mFragmentTransaction.commit();
    }

    @Override
    public void loadStoryList(Story story) {
        currentTag = "StoryList";
        this.story = story;
        mFragmentTransaction = getSupportFragmentManager().beginTransaction();
        mFragmentTransaction.replace(R.id.container, StoryListFragment.getInstance(), StoryFragment.class.getSimpleName());
        mFragmentTransaction.commit();
        StoryListFragment.getInstance().setStory(story);
    }

    @Override
    public void loadStoryContent(SubStories subStories) {
        currentTag = "SubStory";
        mFragmentTransaction = getSupportFragmentManager().beginTransaction();
        mFragmentTransaction.replace(R.id.container, StoryViewFragment.getInstance(), StoryViewFragment.class.getSimpleName());
        mFragmentTransaction.commit();
        StoryViewFragment.getInstance().setSubStory(subStories);
    }

    @Override
    public void onBackPressed() {

        switch ( currentTag ) {
            case "Story" :
                super.onBackPressed();
                break;
            case "StoryList" :
                loadStories();
                break;
            case "SubStory" :
                loadStoryList(story);
                break;
            default:
                super.onBackPressed();
        }

    }
}
