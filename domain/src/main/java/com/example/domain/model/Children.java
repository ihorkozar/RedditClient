package com.example.domain.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Children implements Serializable {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "childrenId")
    private int childrenId;

    @ColumnInfo(name = "kind")
    @SerializedName("kind")
    private String kind;

    @Embedded
    @SerializedName("data")
    private Post post;

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

    public int getChildrenId() {
        return childrenId;
    }

    public void setChildrenId(int childrenId) {
        this.childrenId = childrenId;
    }
}
