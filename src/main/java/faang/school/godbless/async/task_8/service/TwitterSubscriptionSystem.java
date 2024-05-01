package faang.school.godbless.async.task_8.service;

import faang.school.godbless.async.task_8.model.TwitterAccount;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class TwitterSubscriptionSystem {
    private static final long SLEEPING_TIME = 1000;
    private static final ExecutorService EXECUTOR = Executors.newCachedThreadPool();

    public synchronized void addFollower(TwitterAccount account) {
        try {
            Thread.sleep(SLEEPING_TIME);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
        account.setFollowers(account.getFollowers() + 1);
    }

    public CompletableFuture<TwitterAccount> followAccount(TwitterAccount account) {
        return CompletableFuture.supplyAsync(() -> {
            addFollower(account);
            return account;
            }, EXECUTOR);
    }

    public void shutDownPoolOfTwitterSubscriptionSystem() {
        EXECUTOR.shutdown();
    }
}