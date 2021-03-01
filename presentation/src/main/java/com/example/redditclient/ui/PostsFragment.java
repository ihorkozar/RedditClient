package com.example.redditclient.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.redditclient.AppDelegate;
import com.example.redditclient.databinding.PostsBinding;
import com.example.redditclient.ui.image.ImageActivity;
import com.example.redditclient.ui.image.ImageFragment;

import javax.inject.Inject;

import toothpick.Toothpick;

public class PostsFragment extends Fragment {

    @Inject
    PostsViewModel postsViewModel;

    private PostsAdapter.OnItemClickListener onItemClickListener = url -> {
        Intent intent = new Intent(getActivity(), ImageActivity.class);
        Bundle args = new Bundle();
        args.putString(ImageFragment.FRAGMENT_KEY, url);
        intent.putExtra(ImageActivity.ACTIVITY_KEY, args);
        startActivity(intent);
    };

    public static PostsFragment newInstance() {
        return new PostsFragment();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Toothpick.inject(this, AppDelegate.getAppScope());
        postsViewModel.setOnItemClickListener(onItemClickListener);
        postsViewModel.onAttach();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        PostsBinding postsBinding = PostsBinding.inflate(inflater, container, false);
        postsBinding.setViewModel(postsViewModel);
        postsBinding.setLifecycleOwner(this);
        return postsBinding.getRoot();
    }
}
