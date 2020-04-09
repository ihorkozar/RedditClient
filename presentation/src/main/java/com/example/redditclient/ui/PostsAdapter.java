package com.example.redditclient.ui;


import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;

import com.example.domain.model.Children;
import com.example.redditclient.databinding.PostBinding;

public class PostsAdapter extends PagedListAdapter<Children, PostsHolder> {

    private static final DiffUtil.ItemCallback<Children> CALLBACK = new DiffUtil.ItemCallback<Children>() {
        @Override
        public boolean areItemsTheSame(Children oldItem, Children newItem) {
            return oldItem.getPost().getId().equals(newItem.getPost().getId());
        }

        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(Children oldItem, Children newItem) {
            return oldItem.equals(newItem);
        }
    };
    private final OnItemClickListener onItemClickListener;

    @NonNull
    @Override
    public PostsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        PostBinding postBinding = PostBinding.inflate(inflater,parent,false);
        return new PostsHolder(postBinding);
    }

    public PostsAdapter(OnItemClickListener onItemClickListener) {
        super(CALLBACK);
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public void onBindViewHolder(@NonNull PostsHolder holder, int position) {
        Children children = getItem(position);
        if (children != null){
            holder.bind(children.getPost(), onItemClickListener);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(String url);
    }
}
