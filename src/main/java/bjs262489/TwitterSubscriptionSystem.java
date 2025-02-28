package bjs262489;

import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Slf4j
@Getter
public class TwitterSubscriptionSystem {
    private static final int AWAIT_TERMINATION_IN_MS = 2000;
    private static final int THREAD_SLEEP_IN_MS = 1000;
    private final ExecutorService executorService = Executors.newFixedThreadPool(4);
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock writeLock = lock.writeLock();

    public void addFollower(@NonNull TwitterAccount account) {
        try {
            writeLock.lock();
            validateAccountName(account);
            log.info("Inside addFollower. Account: {}, followers number: {}, Thread: {}",
                    account, account.getFollowers(), Thread.currentThread().getName());
            account.getFollowers().incrementAndGet();
            log.info("Inside addFollower. Followers number after increment: {}", account.getFollowers().get());
        } finally {
            writeLock.unlock();
        }
    }

    public void followAccount(TwitterAccount account) {
        CompletableFuture.runAsync(() -> {
            try {
                log.info("Inside followAccount. Account: {}, followers number: {}, Thread: {}",
                        account, account.getFollowers().get(), Thread.currentThread().getName());
                Thread.sleep(THREAD_SLEEP_IN_MS);
                addFollower(account);
                log.info("Inside followAccount. Followers number after increment: {}", account.getFollowers().get());
            } catch (InterruptedException e) {
                log.error("Thread {} interrupted", Thread.currentThread().getId(),
                        new TwitterException("Interrupted exception"));
                Thread.currentThread().interrupt();
            }
        }, executorService);
    }

    public void shutDownExecutorService() {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(AWAIT_TERMINATION_IN_MS, TimeUnit.MILLISECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }

    private void validateAccountName(TwitterAccount account) {
        if (account.getName().isBlank()) {
            throw new IllegalArgumentException("Account`s name can not be null or empty");
        }
    }
}
