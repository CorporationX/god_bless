package com.multithreading.twitter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {

    public static void main(String[] args) {
        TwitterAccount account = new TwitterAccount("durootan@gmail.com");

        TwitterSubscriptionSystem twitter = new TwitterSubscriptionSystem();

        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            futures.add(twitter.followerAccount(account));
        }

        CompletableFuture<Void> allFollowers = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allFollowers.join();
        System.out.println(account.getFollowers().get());
    }

    public synchronized void addFollower(TwitterAccount account) {
        account.getFollowers().addAndGet(1);
    }

    public CompletableFuture<Void> followerAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> addFollower(account));
    }
}
