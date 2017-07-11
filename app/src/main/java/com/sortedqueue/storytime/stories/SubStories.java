package com.sortedqueue.storytime.stories;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Alok on 11/07/17.
 */

public class SubStories implements Parcelable {

    private String storyName;
    private String storyContent;
    private ArrayList<String> storyImages;

    public SubStories(String storyName, String storyContent) {
        this.storyName = storyName;
        this.storyContent = storyContent;
    }

    public SubStories(String storyName, String storyContent, ArrayList<String> storyImages) {
        this.storyName = storyName;
        this.storyContent = storyContent;
        this.storyImages = storyImages;
    }

    public String getStoryName() {
        return storyName;
    }

    public void setStoryName(String storyName) {
        this.storyName = storyName;
    }

    public String getStoryContent() {
        return storyContent;
    }

    public void setStoryContent(String storyContent) {
        this.storyContent = storyContent;
    }

    public ArrayList<String> getStoryImages() {
        if( storyImages == null ) {
            storyImages = new ArrayList<>();
            storyImages.add("http://s.hswstatic.com/gif/childrens-stories-1.jpg");
        }
        return storyImages;
    }

    public void setStoryImages(ArrayList<String> storyImages) {
        this.storyImages = storyImages;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.storyName);
        dest.writeString(this.storyContent);
        dest.writeStringList(this.storyImages);
    }

    protected SubStories(Parcel in) {
        this.storyName = in.readString();
        this.storyContent = in.readString();
        this.storyImages = in.createStringArrayList();
    }

    public static final Parcelable.Creator<SubStories> CREATOR = new Parcelable.Creator<SubStories>() {
        @Override
        public SubStories createFromParcel(Parcel source) {
            return new SubStories(source);
        }

        @Override
        public SubStories[] newArray(int size) {
            return new SubStories[size];
        }
    };
}
