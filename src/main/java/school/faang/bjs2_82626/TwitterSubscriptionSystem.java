package school.faang.bjs2_82626;

import lombok.RequiredArgsConstructor;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@RequiredArgsConstructor
public class TwitterSubscriptionSystem {
    private final ExecutorService threadPool;

    private void addFollower(TwitterAccount account) {
        account.getFollowers().incrementAndGet();
    }

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> addFollower(account), threadPool);
    }
}
