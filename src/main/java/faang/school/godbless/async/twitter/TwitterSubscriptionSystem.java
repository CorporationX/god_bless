package faang.school.godbless.async.twitter;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class TwitterSubscriptionSystem {
    public static final long MIN_FOLLOWING_TIME = 1L;
    public static final long MAX_FOLLOWING_TIME = 3L;
    private final ExecutorService threadPool = Executors.newCachedThreadPool();

    public synchronized void addFollower(TwitterAccount account) {
        if (account == null) {
            throw new IllegalArgumentException("Account cannot be null-valued!");
        }

        try {
            Thread.sleep(new Random().nextLong(MIN_FOLLOWING_TIME, MAX_FOLLOWING_TIME));
        } catch (InterruptedException e) {
            log.error("Following was interrupted.", e);
        }

        account.setFollowers(account.getFollowers() + 1);
    }

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> addFollower(account), threadPool);
    }

    public void shutdownThreadPool() {
        threadPool.shutdown();
    }
}
