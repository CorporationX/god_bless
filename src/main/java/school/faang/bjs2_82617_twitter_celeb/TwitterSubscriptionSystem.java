package school.faang.bjs2_82617_twitter_celeb;

import school.faang.utils.ThreadUtils;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TwitterSubscriptionSystem {
    private static final int SHUTDOWN_DELAY_MINUTES = 10;
    ExecutorService executorService = Executors.newCachedThreadPool();

    public synchronized void addFollower(TwitterAccount account) {
        account.setFollowers(account.getFollowers() + 1);
    }

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(
                () -> addFollower(account),
                executorService
        );
    }

    public void shutDown() {
        ThreadUtils.executorGracefulShutdown(executorService, SHUTDOWN_DELAY_MINUTES, null);
    }

}
