package faang.school.godbless.BJS2_24680;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TwitterSubscriptionSystem {
    private static final ExecutorService executor = Executors.newCachedThreadPool();

    public static CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(
                () -> addFollower(account),
                executor
        );
    }

    private static void addFollower(TwitterAccount account) {
        account.incrementFollowersCount();
    }
}
