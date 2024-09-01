package faang.school.godbless.bjs2_24780;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class TwitterSubscriptionSystem {
    private static final int NUM_THREADS = 100;
    private static final ExecutorService executorService = Executors.newFixedThreadPool(100);

    public synchronized void addFollower(TwitterAccount twitterAccount) {
        twitterAccount.addFollower();
    }

    public CompletableFuture<Void> followAccount(TwitterAccount twitterAccount) {
        return CompletableFuture.runAsync(() -> {
            log.info("Add follower");
            addFollower(twitterAccount);
        }, executorService);
    }

    public void finish() {
        executorService.shutdown();
    }
}
