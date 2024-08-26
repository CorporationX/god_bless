package faang.school.godbless.task.multithreading.async.twitter.selebrity;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class TwitterSubscriptionSystem {
    private final ExecutorService executor;

    public TwitterSubscriptionSystem(int threadPoolSize) {
        executor = Executors.newFixedThreadPool(threadPoolSize);
    }

    private synchronized void addFollowers(TwitterAccount account) {
        account.addFollower();
        log.info("{} have one new follower", account.getUsername());
    }

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> addFollowers(account), executor);
    }

    public void executorShutdown() {
        executor.shutdown();
    }
}
