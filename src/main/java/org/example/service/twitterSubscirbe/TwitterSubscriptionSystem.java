package org.example.service.twitterSubscirbe;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.model.twitterSubscribe.TwitterAccount;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@AllArgsConstructor
public class TwitterSubscriptionSystem {
    public synchronized void addFollower(TwitterAccount account) {
        account.getFollowers().incrementAndGet();
    }

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                log.warn(e.getMessage());
                return null;
            }
            addFollower(account);
            executorService.shutdown();
            return null;
        }, executorService);
    }
}
