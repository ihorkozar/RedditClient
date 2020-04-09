package com.example.redditclient.ui.image;

import androidx.fragment.app.Fragment;

import com.example.redditclient.common.RefreshActivity;

public class ImageActivity extends RefreshActivity {
    public static final String ACTIVITY_KEY = "ACTIVITY_KEY";

    @Override
    protected Fragment getFragment() {
        if (getIntent() != null) {
            return ImageFragment.newInstance(getIntent().getBundleExtra(ACTIVITY_KEY));
        }
        throw new IllegalStateException("getIntent cannot be null");
    }
}
