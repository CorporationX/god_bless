package school.faang.bjs251771;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;


@Slf4j
public class TwitterSubscriptionSystem {
    private synchronized void addFollower(TwitterAccount account) {
        account.setFollowers(account.getFollowers() + 1);
    }

    public CompletableFuture<Void> followAccount(TwitterAccount account, ExecutorService executor) {
        return CompletableFuture.runAsync(() -> addFollower(account), executor);
    }
}
