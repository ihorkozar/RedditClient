package com.example.redditclient.ui;

import androidx.lifecycle.ViewModel;

import com.example.domain.model.Post;

public class PostsListItemViewModel extends ViewModel {

    private String author, publishedOn, imageUrl, numberOfComments, title;

    public PostsListItemViewModel(Post item) {
        author = item.getAuthor();
        publishedOn = String.valueOf((System.currentTimeMillis() / 1000 - item.getCreated_utc()) / 3600) + " " + "hours ago";
        imageUrl = item.getThumbnail();
        numberOfComments = String.valueOf(item.getNum_comments()) + "comments";
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
