package com.example.redditclient.di;

import com.example.data.repository.PostDataBaseRepository;
import com.example.data.repository.PostServerRepository;
import com.example.domain.repository.PostRepository;

import toothpick.config.Module;

public class RepositoryModule extends Module {

    public RepositoryModule() {
        bind(PostRepository.class).withName(PostRepository.SERVER).to(PostServerRepository.class);
        bind(PostRepository.class).withName(PostRepository.DATABASE).to(PostDataBaseRepository.class);
    }

    PostRepository providePostServerRepository(PostServerRepository postServerRepository){
        return postServerRepository;
    }

    PostRepository providePostDataBaseRepository(PostDataBaseRepository postDataBaseRepository){
        return postDataBaseRepository;
    }
}
