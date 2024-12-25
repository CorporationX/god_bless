package school.faang.task_50704;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TwitterSubscriptionSystem {
    private ExecutorService executor = Executors.newCachedThreadPool();

    public synchronized void addFollower(TwitterAccount account) {
        account.setFollowers(account.getFollowers() + 1);
    }

    public CompletableFuture<TwitterAccount> followAccount(TwitterAccount account) {
        return CompletableFuture.supplyAsync(() -> {
                    addFollower(account);
                    return account;
                }, executor)
                .thenApply(follower -> {
                    System.out.println("Follower добавлен: " + follower.getUsername());
                    return follower;
                });
    }

    public void shutdownExecutor() {
        executor.shutdown();
    }
}
