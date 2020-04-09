package com.example.redditclient.ui.image;

import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

public class ImageViewModel extends ViewModel {
    private String url;

    @Inject
    public ImageViewModel() {
        super();
    }

    public void onAttach(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
