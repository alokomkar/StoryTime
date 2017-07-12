package com.sortedqueue.storytime.stories;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Alok Omkar on 2017-07-07.
 */

public class Story implements Parcelable {

    private String storyId;
    private String storyName;
    private String storyType;
    private String storyImage;
    private static ArrayList<Story> storyList;
    private ArrayList<SubStories> subStories;

    public Story() {
    }

    public Story(String storyName, String storyType, String storyImage) {
        this.storyName = storyName;
        this.storyType = storyType;
        this.storyImage = storyImage;
    }

    public Story(String storyId, String storyName, String storyType, String storyImage) {
        this.storyId = storyId;
        this.storyName = storyName;
        this.storyType = storyType;
        this.storyImage = storyImage;
    }

    public static ArrayList<Story> getStoryList() {
        storyList = new ArrayList<>();
        int id = 1;
        Story story = new Story(
                "story_"+id++,
                "Animal Stories",
                "Mythology",
                "http://cdn2.momjunction.com/wp-content/uploads/2014/06/Animal-Stories-For-Your-Kids.jpg");


        ArrayList<SubStories> subStories = new ArrayList<>();

        subStories.add(new SubStories("A friend in need is a friend indeed.", "Once upon a time there lived a lion in a forest. One day after a heavy meal. It was sleeping under a tree. After a while, there came a mouse and it started to play on the lion. Suddenly the lion got up with anger and looked for those who disturbed its nice sleep. Then it saw a small mouse standing trembling with fear. The lion jumped on it and started to kill it. The mouse requested the lion to forgive it. The lion felt pity and left it. The mouse ran away. \n" +
                "\n" +
                "\n" +
                "\n" +
                "On another day, the lion was caught in a net by a hunter. The mouse came there and cut the net. Thus it escaped. There after, the mouse and the lion became friends. They lived happily in the forest afterwards. "));
        subStories.add(new SubStories("A Town Mouse and A Country Mouse", ""));
        subStories.add(new SubStories("Elephant and Friends", ""));
        subStories.add(new SubStories("Four Friends", ""));
        subStories.add(new SubStories("Hungry Wolf", ""));
        subStories.add(new SubStories("The Clever Crab", ""));
        subStories.add(new SubStories("The Clever Frog", ""));
        subStories.add(new SubStories("The Crane and The Snake", ""));
        subStories.add(new SubStories("The Crow and The Eagle", ""));
        subStories.add(new SubStories("The Crow and The Necklace", ""));
        subStories.add(new SubStories("The Donkey and The Load of Salt", ""));
        subStories.add(new SubStories("The Donkey Who Would Sing", ""));
        subStories.add(new SubStories("The Faithful Mongoose", ""));
        subStories.add(new SubStories("The Foolish Crow", ""));
        subStories.add(new SubStories("The Frog and The Ox", ""));
        subStories.add(new SubStories("The Indigo Jackal", ""));
        subStories.add(new SubStories("The Jackal and The War Drum", ""));
        subStories.add(new SubStories("The Lion and The Hare", ""));
        subStories.add(new SubStories("The Lazy Dreamer", ""));
        subStories.add(new SubStories("The Merchant and The Foolish Barber", ""));
        subStories.add(new SubStories("The Foolish Lion", ""));
        story.setSubStories(subStories);
        storyList.add(story);

        storyList.add(new Story(
                "story_"+id++,
                "Witty Tales",
                "Mythology",
                "http://moralstories26.com/img/2017/04/Nasruddin-Hoja-Stories-Funny-and-Witty-Solution-for-Problems-Stories.jpg"));
        storyList.add(new Story(
                "story_"+id++,
                "Moral Stories",
                "Mythology",
                "https://www.universallearningacademy.com/wp-content/uploads/2016/09/cat-and-fox-370x297.jpg"));
        storyList.add(new Story(
                "story_"+id++,
                "Humor Stories",
                "Mythology",
                "http://dimdima.com/images/story_image/best_artist.jpg"));
        storyList.add(new Story(
                "story_"+id++,
                "Zen Stories",
                "Mythology",
                "http://cdn-5.english-for-students.com/images/RightMove.jpg"));
        storyList.add(new Story(
                "story_"+id++,
                "Tenali Raman Stories",
                "Mythology",
                "http://www.4to40.com/wordpress/wp-content/uploads/2016/08/golden-peacock.jpg"));
        storyList.add(new Story(
                "story_"+id++,
                "Mulla Stories",
                "Mythology",
                "http://cdn-6.english-for-students.com/images/HodjaSuggestsaRemedy.gif"));
        storyList.add(new Story(
                "story_"+id++,
                "Aesop's Fables",
                "Mythology",
                "http://www.kids-pages.com/folders/stories/Aesops_Fables/crowandfox.jpg"));



        return storyList;
    }

    public String getStoryId() {
        return storyId;
    }

    public void setStoryId(String storyId) {
        this.storyId = storyId;
    }

    public String getStoryName() {
        return storyName;
    }

    public void setStoryName(String storyName) {
        this.storyName = storyName;
    }

    public String getStoryType() {
        return storyType;
    }

    public void setStoryType(String storyType) {
        this.storyType = storyType;
    }

    public String getStoryImage() {
        return storyImage;
    }

    public void setStoryImage(String storyImage) {
        this.storyImage = storyImage;
    }

    public ArrayList<SubStories> getSubStories() {
        return subStories;
    }

    public void setSubStories(ArrayList<SubStories> subStories) {
        this.subStories = subStories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Story story = (Story) o;

        if (storyId != null ? !storyId.equals(story.storyId) : story.storyId != null) return false;
        if (storyName != null ? !storyName.equals(story.storyName) : story.storyName != null)
            return false;
        if (storyType != null ? !storyType.equals(story.storyType) : story.storyType != null)
            return false;
        return storyImage != null ? storyImage.equals(story.storyImage) : story.storyImage == null;

    }

    @Override
    public int hashCode() {
        int result = storyId != null ? storyId.hashCode() : 0;
        result = 31 * result + (storyName != null ? storyName.hashCode() : 0);
        result = 31 * result + (storyType != null ? storyType.hashCode() : 0);
        result = 31 * result + (storyImage != null ? storyImage.hashCode() : 0);
        return result;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.storyId);
        dest.writeString(this.storyName);
        dest.writeString(this.storyType);
        dest.writeString(this.storyImage);
        dest.writeTypedList(this.subStories);
    }

    protected Story(Parcel in) {
        this.storyId = in.readString();
        this.storyName = in.readString();
        this.storyType = in.readString();
        this.storyImage = in.readString();
        this.subStories = in.createTypedArrayList(SubStories.CREATOR);
    }

    public static final Creator<Story> CREATOR = new Creator<Story>() {
        @Override
        public Story createFromParcel(Parcel source) {
            return new Story(source);
        }

        @Override
        public Story[] newArray(int size) {
            return new Story[size];
        }
    };
}
