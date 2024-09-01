package com.multithreading.twitter;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;
@Getter
@Setter
public class TwitterAccount {
    private String username;
    private final AtomicInteger followers = new AtomicInteger();

    public TwitterAccount(String username) {
        this.username = username;
    }
}
