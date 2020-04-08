package com.example.data.repository;

import com.example.data.database.RedditDao;
import com.example.domain.model.Children;
import com.example.domain.repository.PostRepository;

import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;

import io.reactivex.Single;

public class PostDataBaseRepository implements PostRepository {
    @Inject
    RedditDao redditDao;

    @Inject
    public PostDataBaseRepository() {
    }

    @Override
    public Single<List<Children>> getChildren() {
        return Single.fromCallable(new Callable<List<Children>>() {
            @Override
            public List<Children> call() throws Exception {
                List<Children> children = redditDao.getChildren();
                return children;
            }
        });
    }

    @Override
    public void insertChildren(List<Children> children) {
        redditDao.insertChildren(children);
    }
}
