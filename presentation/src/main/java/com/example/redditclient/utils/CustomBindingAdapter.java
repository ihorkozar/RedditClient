package com.example.redditclient.utils;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.domain.model.Children;
import com.example.redditclient.ui.PostsAdapter;

public class CustomBindingAdapter {

    @BindingAdapter("bind:ImageUrl")
    public static void loadImage(ImageView imageView, String urlImage){
        Glide.with(imageView.getContext())
                .load(urlImage)
                .apply(RequestOptions.circleCropTransform())
                .into(imageView);
    }

    @BindingAdapter("bind:FullImageUrl")
    public static void loadFullImage(ImageView imageView, String urlImage) {
        Glide.with(imageView.getContext())
                .load(urlImage)
                .into(imageView);
    }

    /*@BindingAdapter({"bind:data", "bind:clickHandler"})
    public static void configureRecyclerView(RecyclerView recyclerView,
                                             RecyclerViewViewModel viewModel,
                                             PagedList<Children> children,
                                             PostsAdapter.OnItemClickListener listener) {
        viewModel.setupRecyclerView(recyclerView, listener, children);
    }*/

    @BindingAdapter({"bind:data", "bind:clickHandler"})
    public static void configureRecyclerView(RecyclerView recyclerView,
                                             PagedList<Children> children,
                                             PostsAdapter.OnItemClickListener listener) {
        PostsAdapter adapter = new PostsAdapter(listener);
        adapter.submitList(children);
        LinearLayoutManager layoutManager = new LinearLayoutManager(recyclerView.getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @BindingAdapter({"bind:refreshState", "bind:onRefresh"})
    public static void configureSwipeRefreshLayout(SwipeRefreshLayout refreshLayout,
                                                   boolean isLoading,
                                                   SwipeRefreshLayout.OnRefreshListener listener){
        refreshLayout.setOnRefreshListener(listener);
        refreshLayout.post(()-> refreshLayout.setRefreshing(isLoading));
    }
}
