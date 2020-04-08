package com.example.data.repository;

import com.example.data.api.RedditApi;
import com.example.domain.model.Children;
import com.example.domain.model.PostResponse;
import com.example.domain.repository.PostRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.functions.Function;

public class PostServerRepository implements PostRepository {
    @Inject
    RedditApi redditApi;

    @Inject
    public PostServerRepository() {
    }

    @Override
    public Single<List<Children>> getChildren() {
        return redditApi.getPosts(null,10).map(new Function<PostResponse, List<Children>>() {
            @Override
            public List<Children> apply(PostResponse postResponse) throws Exception {
                return postResponse.getData().getChildren();
            }
        });
    }

    @Override
    public void insertChildren(List<Children> children) {
        // do nothing
    }
}
