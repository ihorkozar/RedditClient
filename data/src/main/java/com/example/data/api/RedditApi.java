package com.example.data.api;

import com.example.domain.model.PostResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RedditApi {

    @GET("top.json")
    Single<PostResponse> getPosts(@Query("after") String after, @Query("limit") int limit);
}
