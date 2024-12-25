package school.faang.sprint4.task_50732;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class TwitterSubscriptionSystem {

    private void addFollower(TwitterAccount account) {
        int followerCount = account.getFollowersCount().incrementAndGet();
        log.info("+1 follower to {}. Total followers: {}", account.getUsername(), followerCount);
    }

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> addFollower(account));
    }
}
