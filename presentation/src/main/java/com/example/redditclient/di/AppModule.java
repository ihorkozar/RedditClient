package com.example.redditclient.di;

import androidx.room.Room;

import com.example.data.database.RedditDao;
import com.example.data.database.RedditDatabase;
import com.example.redditclient.AppDelegate;

import javax.inject.Inject;

import toothpick.config.Module;

public class AppModule extends Module {
    @Inject
    RedditDao redditDao;

    private final AppDelegate appDelegate;

    public AppModule(AppDelegate app) {
        this.appDelegate = app;
        bind(AppDelegate.class).toInstance(provideAppDelegate());
        bind(RedditDao.class).toInstance(provideRedditDao(provideDataBase()));
    }

    AppDelegate provideAppDelegate(){
        return appDelegate;
    }

    RedditDatabase provideDataBase(){
        return Room.databaseBuilder(appDelegate, RedditDatabase.class, "reddit_database")
                .fallbackToDestructiveMigration()
                .build();
    }

    RedditDao provideRedditDao(RedditDatabase redditDatabase){
        return redditDatabase.getRedditDao();
    }
}
