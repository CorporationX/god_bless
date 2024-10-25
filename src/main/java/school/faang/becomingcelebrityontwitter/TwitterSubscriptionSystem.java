package school.faang.becomingcelebrityontwitter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TwitterSubscriptionSystem {
    private final Lock lock = new ReentrantLock();

    public void addFollower(TwitterAccount account) {
        lock.lock();
        try {
            int currentFollowers = account.getFollowers();
            account.setFollowers(currentFollowers + 1);
            System.out.println("Added follower to account: " + account.getUsername() + ". Total followers: " +
                    account.getFollowers());
        } finally {
            lock.unlock();
        }
    }

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> addFollower(account));
    }

    public void followMultipleTimes(TwitterAccount account, int times) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        CompletableFuture<Void>[] tasks = new CompletableFuture[times];

        for (int i = 0; i < times; i++) {
            tasks[i] = followAccount(account);
        }

        CompletableFuture.allOf(tasks).thenRun(() ->
                System.out.println("All tasks completed. Final followers count: " + account.getFollowers())
        ).join();

        executorService.shutdown();
    }
}

