package school.faang.sprints.sprint4.celebritytwitter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TwitterSubscriptionSystem {

    ExecutorService executor = Executors.newCachedThreadPool();

    public void addFollower(TwitterAccount account) {
        synchronized (account) {
            account.setFollowers(account.getFollowers() + 1);
        }
    }

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> addFollower(account), executor);
    }
}
