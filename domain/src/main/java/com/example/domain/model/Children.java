package com.example.domain.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity
public class Children implements Serializable {

    @NonNull
    @ColumnInfo(name = "childrenId")
    @PrimaryKey(autoGenerate = true)
    private int childrenId;

    @ColumnInfo(name = "kind")
    @SerializedName("kind")
    private String kind;

    @Embedded
    @SerializedName("data")
    private Post post;

    public int getChildrenId() {
        return childrenId;
    }

    public String getKind() {
        return kind;
    }

    public Post getPost() {
        return post;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public void setChildrenId(int childrenId) {
        this.childrenId = childrenId;
    }
}
