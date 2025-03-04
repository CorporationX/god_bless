package school.faang.task_62511;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class TwitterSubscriptionSystem {
    private static final int TERMINATION_AWAIT_TIME = 1;
    private static final int ONE_FOLLOWER = 1;

    private final ExecutorService executor = Executors.newFixedThreadPool(3);

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        String username = account.getUsername();

        return CompletableFuture.runAsync(() -> {
            log.info(TwitterSubscriptionMessage.START_ACCOUNT_FOLLOW.getMessage(), username);
            addFollower(account);
            log.info(TwitterSubscriptionMessage.END_ACCOUNT_FOLLOW.getMessage(), username);
        }, executor);
    }

    private synchronized void addFollower(TwitterAccount account) {
        account.setFollowers(account.getFollowers() + ONE_FOLLOWER);
    }

    public void shutdownExecutor() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(TERMINATION_AWAIT_TIME, TimeUnit.MINUTES)) {
                log.error(TwitterSubscriptionMessage.TERMINATION_AWAIT_EXCEPTION.getMessage());
            }
        } catch (InterruptedException e) {
            log.error(TwitterSubscriptionMessage.INTERRUPT_EXCEPTION.getMessage());
            Thread.currentThread().interrupt();
            throw new RuntimeException(TwitterSubscriptionMessage.INTERRUPT_EXCEPTION.getMessage(), e);
        } finally {
            if (!executor.isTerminated()) {
                executor.shutdownNow();
            }
        }
    }
}
