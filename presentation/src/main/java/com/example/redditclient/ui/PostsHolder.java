package com.example.redditclient.ui;

import androidx.recyclerview.widget.RecyclerView;

import com.example.domain.model.Children;
import com.example.domain.model.Post;
import com.example.redditclient.databinding.PostBinding;

public class PostsHolder extends RecyclerView.ViewHolder {

    private PostBinding postBinding;

    public PostsHolder(PostBinding binding) {
        super(binding.getRoot());
        postBinding = binding;
    }

    public void bind(Post item) {
        postBinding.setPost(new PostsListItemViewModel(item));
        postBinding.executePendingBindings();
    }
}
