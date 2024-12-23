package school.faang.task_50678;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int NUM_TRHEADS = 5;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_TRHEADS);
        TwitterSubscriptionSystem subscriptionSystem = new TwitterSubscriptionSystem(executorService);
        TwitterAccount account = new TwitterAccount("exprnc");

        CompletableFuture<Void> allFollows = CompletableFuture.allOf(subscriptionSystem.followAccount(account),
                subscriptionSystem.followAccount(account),
                subscriptionSystem.followAccount(account));

        allFollows.join();

        log.info("{} has the number of subscribers: {}", account.getUsername(), account.getFollowers());

        executorService.shutdown();
        try {
            if (executorService.awaitTermination(30, TimeUnit.SECONDS)) {
                log.info("All tasks successfully completed");
            } else {
                log.info("Tasks not completed");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }
}
