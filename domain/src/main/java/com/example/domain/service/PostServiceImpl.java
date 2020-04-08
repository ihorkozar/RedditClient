package com.example.domain.service;

import com.example.domain.ApiUtils;
import com.example.domain.model.Children;
import com.example.domain.model.PostResponse;
import com.example.domain.repository.PostRepository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class PostServiceImpl implements PostService{

    @Inject
    @Named(PostRepository.SERVER)
    PostRepository postServerRepository;

    @Inject
    @Named(PostRepository.DATABASE)
    PostRepository postDataBaseRepository;

    @Inject
    public PostServiceImpl() {
    }

    @Override
    public Single<List<Children>> getChildren() {
        return postServerRepository
                .getChildren()
                .subscribeOn(Schedulers.io())
                .doOnSuccess(postDataBaseRepository::insertChildren)
                .onErrorReturn(throwable ->
                        ApiUtils.NETWORK_EXCEPTIONS.contains(throwable.getClass())
                                ? postDataBaseRepository.getChildren().blockingGet()
                                :null);
    }

    @Override
    public void insertChildren(List<Children> children) {
        postDataBaseRepository.insertChildren(children);
    }
}
