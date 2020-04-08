package com.example.domain.service;

import com.example.domain.model.Children;
import com.example.domain.model.PostResponse;

import java.util.List;

import io.reactivex.Single;

public interface PostService {
    Single<List<Children>> getChildren();

    void insertChildren(List<Children> children);
}
