package com.example.redditclient.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.provider.MediaStore;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class ImageSaver extends AsyncTask<String, Void, String> {

    private Context context;

    public ImageSaver(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(String... strings) {
        URL imageurl = null;
        try {
            imageurl = new URL(strings[0]);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            Bitmap bitmap = BitmapFactory.decodeStream(imageurl.openConnection().getInputStream());
            MediaStore.Images.Media.insertImage(context.getContentResolver(), bitmap, "", "");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return strings[0];
    }
}
