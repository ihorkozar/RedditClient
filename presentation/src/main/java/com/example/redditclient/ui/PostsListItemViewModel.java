package com.example.redditclient.ui;

import androidx.lifecycle.ViewModel;

import com.example.domain.model.Children;
import com.example.domain.model.Post;

public class PostsListItemViewModel extends ViewModel {

    private String author, publishedOn, imageUrl, numberOfComments;

    public PostsListItemViewModel(Post item) {
        author = item.getAuthor();
        publishedOn = String.valueOf(item.getCreated_utc());
        imageUrl = item.getThumbnail();
        numberOfComments = String.valueOf(item.getNum_comments());
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
}
