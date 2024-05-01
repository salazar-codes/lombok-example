package com.jimmysalazar.lombokexample.model;

import lombok.NonNull;

public class TwitterAccount {

    private String username;

    public TwitterAccount(@NonNull String username) {
        super();
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
