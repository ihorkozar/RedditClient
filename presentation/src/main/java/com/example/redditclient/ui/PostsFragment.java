package com.example.redditclient.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;

import com.example.data.database.RedditDao;
import com.example.domain.model.Children;
import com.example.redditclient.AppDelegate;
import com.example.redditclient.common.SingleFragmentActivity;
import com.example.redditclient.databinding.PostsBinding;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.List;

import javax.inject.Inject;

import toothpick.Toothpick;

public class PostsFragment extends Fragment {

    @Inject
    PostsViewModel postsViewModel;

    public static PostsFragment newInstance(){
        return new PostsFragment();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Toothpick.inject(this, AppDelegate.getAppScope());
        postsViewModel.onAttach();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        PostsBinding postsBinding = PostsBinding.inflate(inflater,container,false);
        postsBinding.setViewModel(postsViewModel);
        postsBinding.setLifecycleOwner(this);
        return postsBinding.getRoot();
    }
}
