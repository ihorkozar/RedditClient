package com.example.redditclient.di;

import com.example.data.api.RedditApi;
import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import toothpick.config.Module;

public class NetworkModule extends Module {
    private final Gson gson = provideGson();
    //private final OkHttpClient okHttpClient = provideClient();
    private final Retrofit retrofit = provideRetrofit();

    public NetworkModule() {
        bind(Gson.class).toInstance(gson);
        //bind(OkHttpClient.class).toInstance(okHttpClient);
        bind(Retrofit.class).toInstance(retrofit);
        bind(RedditApi.class).toInstance(provideApiService());
    }

    Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(com.example.data.BuildConfig.API_URL)
                // need for interceptors
                //.client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    OkHttpClient provideClient() {
        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        return builder.build();
    }

    Gson provideGson() {
        return new Gson();
    }

    RedditApi provideApiService() {
        return retrofit.create(RedditApi.class);
    }
}
