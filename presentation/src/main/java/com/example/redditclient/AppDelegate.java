package com.example.redditclient;

import android.app.Application;

import com.example.redditclient.di.AppModule;
import com.example.redditclient.di.NetworkModule;
import com.example.redditclient.di.RepositoryModule;
import com.example.redditclient.di.ServiceModule;

import toothpick.Scope;
import toothpick.Toothpick;
import toothpick.smoothie.module.SmoothieApplicationModule;

public class AppDelegate extends Application {

    public static Scope appScope;

    @Override
    public void onCreate() {
        super.onCreate();

        appScope = Toothpick.openScope(AppDelegate.class);
        appScope.installModules(new SmoothieApplicationModule(this),
                new NetworkModule(),
                new AppModule(this),
                new RepositoryModule(),
                new ServiceModule());
    }

    public static Scope getAppScope(){
        return appScope;
    }
}
