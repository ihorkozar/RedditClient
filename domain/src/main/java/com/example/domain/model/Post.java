package com.example.domain.model;

import java.io.Serializable;
import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.google.gson.annotations.SerializedName;

@Entity
public class Post implements Serializable {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    @SerializedName("id")
    private String id;

    @ColumnInfo(name = "title")
    @SerializedName("title")
    private String title;

    @ColumnInfo(name = "author")
    @SerializedName("author")
    private String author;

    @ColumnInfo(name = "created_utc")
    @SerializedName("created_utc")
    private long created_utc; //время создания

    @ColumnInfo(name = "thumbnail")
    @SerializedName("thumbnail")
    private String thumbnail; //ссылка на картинку

    @ColumnInfo(name = "num_comments")
    @SerializedName("num_comments")
    private int num_comments; //количество коментариев

    @ColumnInfo(name = "sourceUrl")
    @SerializedName("sourceUrl")
    private String sourceUrl;


    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public long getCreated_utc() {
        return created_utc;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public int getNum_comments() {
        return num_comments;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCreated_utc(long created_utc) {
        this.created_utc = created_utc;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public void setNum_comments(int num_comments) {
        this.num_comments = num_comments;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }
}
