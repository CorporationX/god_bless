package school.faang.bjs250924;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class TwitterSubscriptionSystem {
    private final ExecutorService executorService;

    public TwitterSubscriptionSystem(ExecutorService executorService) {
        this.executorService = executorService;
    }

    private void addFollower(TwitterAccount account) {
        account.updateFollowersCount(1);
    }

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> {
            addFollower(account);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, executorService);
    }
}
