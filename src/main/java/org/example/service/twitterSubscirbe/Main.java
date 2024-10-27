package org.example.service.twitterSubscirbe;

import org.example.model.twitterSubscribe.TwitterAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static final int FOLLOWERS_NUM = 1000;

    public static void main(String[] args) {
        TwitterSubscriptionSystem subscriptionSystem = new TwitterSubscriptionSystem();
        List<CompletableFuture<Void>> subscribingFuture = new ArrayList<>();
        TwitterAccount account = new TwitterAccount("ZhubanyshZh", new AtomicInteger(10));

        for (int i = 0; i < FOLLOWERS_NUM; i++) {
            subscribingFuture.add(subscriptionSystem.followAccount(account));
        }
        subscriptionSystem.shutdownPoolThreads();

        CompletableFuture<Void> subscribedFutures = CompletableFuture.allOf(subscribingFuture.toArray(new CompletableFuture[0]));
        subscribedFutures.join();

        subscribedFutures.thenRun(() -> System.out.println(account.getFollowers()));
    }
}
