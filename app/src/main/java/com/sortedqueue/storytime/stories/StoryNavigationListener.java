package com.sortedqueue.storytime.stories;

/**
 * Created by Alok Omkar on 2017-07-09.
 */

public interface StoryNavigationListener {
    void loadStories();
    void loadStoryList(Story story);
    void loadStoryContent( SubStories subStories );
}
