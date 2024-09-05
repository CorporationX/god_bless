package faang.school.godbless.BJS224874;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class TwitterSubscriptionSystem {
    private static final ExecutorService executor = Executors.newCachedThreadPool();

    public static CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> addFollower(account), executor);
    }

    private static void addFollower(TwitterAccount account) {
        account.incrementFollowersCount();
        log.info(account.getUsername() + " get " + account.getFollowersCount() + " follower!");
    }
}