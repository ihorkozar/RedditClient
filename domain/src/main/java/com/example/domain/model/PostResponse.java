package com.example.domain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class PostResponse implements Serializable {

    @SerializedName("data")
    private final Data data;

    public PostResponse(Data data) {
        this.data = data;
    }

    public Data getData() {
        return data;
    }

    public static class Data {

        @SerializedName("children")
        private List<Children> children;

        public List<Children> getChildren() {
            return children;
        }

        public void setChildren(List<Children> children) {
            this.children = children;
        }
    }
}