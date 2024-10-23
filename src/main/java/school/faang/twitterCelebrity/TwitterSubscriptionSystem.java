package school.faang.twitterCelebrity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class TwitterSubscriptionSystem {
    private static final int THREAD_SLEEP_TIME = 3000;
    private static final Logger log = LoggerFactory.getLogger(TwitterSubscriptionSystem.class);
    private static final ExecutorService service =
            Executors.newCachedThreadPool();

    public synchronized void addFollower(TwitterAccount account) {
        account.addFollowers();
    }

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> {
            threadSleep();
            addFollower(account);
        }, service);
    }

    public void addAllFollowers(TwitterAccount account, int numberOfFollowers) {
        List<CompletableFuture<Void>> allFollowers =
                IntStream.range(0, numberOfFollowers)
                        .mapToObj(i -> followAccount(account))
                        .toList();

        CompletableFuture.allOf(
                        allFollowers.toArray(new CompletableFuture[0]))
                .thenRun(() ->
                        log.info("Account name: {} Total followers: {}",
                                account.getUsername(), account.getFollowers()));
    }

    public void threadSleep() {
        try {
            Thread.sleep(THREAD_SLEEP_TIME);
        } catch (InterruptedException e) {
            log.warn("Thread was interrupted{}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void shutDown() {
        service.shutdown();
    }
}
