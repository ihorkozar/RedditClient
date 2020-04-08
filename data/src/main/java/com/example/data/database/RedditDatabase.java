package com.example.data.database;

import androidx.room.RoomDatabase;
import androidx.room.Database;

import com.example.domain.model.Children;
import com.example.domain.model.Post;

@Database(entities = {Post.class, Children.class}, version = 1)
public abstract class RedditDatabase extends RoomDatabase {
    public abstract RedditDao getRedditDao();
}
