package com.company.chatterbox.models;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;

    private List<ChatterPost> ChatterPosts = new ArrayList<>();

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ChatterPost> getChatterPosts() {
        return ChatterPosts;
    }

    public void setChatterPosts(List<ChatterPost> chatterPosts) {
        ChatterPosts = chatterPosts;
    }
}
