package com.sortedqueue.storytime.stories;

/**
 * Created by Alok Omkar on 2017-07-07.
 */

public class StoryChapters {

    private String storyId;
    private String chapterId;
    private String chapterTitle;
    private String chapterImage;
    private String chapterContent;

    public StoryChapters(String storyId, String chapterId, String chapterTitle, String chapterImage, String chapterContent) {
        this.storyId = storyId;
        this.chapterId = chapterId;
        this.chapterTitle = chapterTitle;
        this.chapterImage = chapterImage;
        this.chapterContent = chapterContent;
    }

    public StoryChapters() {
    }

    public String getStoryId() {
        return storyId;
    }

    public void setStoryId(String storyId) {
        this.storyId = storyId;
    }

    public String getChapterId() {
        return chapterId;
    }

    public void setChapterId(String chapterId) {
        this.chapterId = chapterId;
    }

    public String getChapterTitle() {
        return chapterTitle;
    }

    public void setChapterTitle(String chapterTitle) {
        this.chapterTitle = chapterTitle;
    }

    public String getChapterImage() {
        return chapterImage;
    }

    public void setChapterImage(String chapterImage) {
        this.chapterImage = chapterImage;
    }

    public String getChapterContent() {
        return chapterContent;
    }

    public void setChapterContent(String chapterContent) {
        this.chapterContent = chapterContent;
    }
}
