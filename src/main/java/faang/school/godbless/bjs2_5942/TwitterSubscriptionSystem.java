package faang.school.godbless.bjs2_5942;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class TwitterSubscriptionSystem {

    private final ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public synchronized void addFollower(TwitterAccount twitterAccount) {
        twitterAccount.setFollowers(twitterAccount.getFollowers() + 1);
        log.info("Current followers for {} is: {}", twitterAccount.getUsername(), twitterAccount.getFollowers());
    }

    public CompletableFuture<Void> followAccount(TwitterAccount twitterAccount) {
        return CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                addFollower(twitterAccount);
            }
        }, executorService).thenRun(executorService::shutdown);
    }
}
