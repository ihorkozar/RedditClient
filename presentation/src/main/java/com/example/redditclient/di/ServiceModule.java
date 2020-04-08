package com.example.redditclient.di;

import com.example.domain.service.PostService;
import com.example.domain.service.PostServiceImpl;

import toothpick.config.Module;

public class ServiceModule extends Module {

    PostServiceImpl postService;

    public ServiceModule() {
        bind(PostService.class).to(PostServiceImpl.class);
    }

    PostService providePostService(PostServiceImpl postService){
        return postService;
    }
}
