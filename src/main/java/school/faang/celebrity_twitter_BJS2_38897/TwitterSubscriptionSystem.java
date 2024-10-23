package school.faang.celebrity_twitter_BJS2_38897;

import lombok.Getter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Getter
public class TwitterSubscriptionSystem {
    private final int COUNT_THREADS = 100;
    private final ExecutorService executor = Executors.newFixedThreadPool(COUNT_THREADS);

    public synchronized void addFollower(TwitterAccount account) {
        account.setFollowers(account.getFollowers() + 1);
    }

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() ->
                addFollower(account), executor);
    }
}