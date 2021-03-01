package com.example.redditclient.ui;

import androidx.lifecycle.ViewModel;

import com.example.domain.model.Post;

public class PostsListItemViewModel extends ViewModel {

    private final String author;
    private final String publishedOn;
    private final String imageUrl;
    private final String numberOfComments;
    private final String title;

    public PostsListItemViewModel(Post item) {
        author = item.getAuthor();
        publishedOn = (System.currentTimeMillis() / 1000 - item.getCreated_utc()) / 3600 + " " + "hours ago";
        imageUrl = item.getThumbnail();
        numberOfComments = item.getNum_comments() + "comments";
        title = item.getTitle();
    }

    public String getAuthor() {
        return author;
    }

    public String getPublishedOn() {
        return publishedOn;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getNumberOfComments() {
        return numberOfComments;
    }

    public String getTitle() {
        return title;
    }
}
