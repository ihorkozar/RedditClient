package com.example.redditclient.ui;


import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;

import com.example.domain.model.Children;
import com.example.domain.model.Post;
import com.example.redditclient.databinding.PostBinding;

public class PostsAdapter extends PagedListAdapter<Children, PostsHolder> {

    public PostsAdapter() {
        super(CALLBACK);
    }

    @NonNull
    @Override
    public PostsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        PostBinding postBinding = PostBinding.inflate(inflater,parent,false);
        return new PostsHolder(postBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull PostsHolder holder, int position) {
        Children children = getItem(position);
        if (children != null){
            holder.bind(children.getPost());
        }
    }

    private static final DiffUtil.ItemCallback<Children> CALLBACK = new DiffUtil.ItemCallback<Children>() {
        @Override
        public boolean areItemsTheSame(Children oldItem, Children newItem) {
            return oldItem.getChildrenId() == newItem.getChildrenId();
        }

        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(Children oldItem, Children newItem) {
            return oldItem.equals(newItem);
        }
    };
}
