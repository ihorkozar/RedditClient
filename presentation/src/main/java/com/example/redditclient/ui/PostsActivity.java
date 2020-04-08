package com.example.redditclient.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.example.redditclient.common.SingleFragmentActivity;

public class PostsActivity extends SingleFragmentActivity {

    @Override
    protected Fragment getFragment() {
        return PostsFragment.newInstance();
    }
}
