package com.example.domain.repository;

import com.example.domain.model.Children;
import com.example.domain.model.PostResponse;

import java.util.List;

import io.reactivex.Single;

public interface PostRepository {

    String SERVER = "SERVER";
    String DATABASE = "DATABASE";

    Single<List<Children>> getChildren();

    void insertChildren(List<Children> children);
}
