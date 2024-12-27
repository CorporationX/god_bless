package school.faang.sprint_4.task_bjs250903;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int EXECUTOR_THREADS_AMOUNT = 50;
    private static final int NEW_SUBSCRIBERS_AMOUNT = 1770;
    public static final int AWAIT_TERMINATION_SECONDS = 10;

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(EXECUTOR_THREADS_AMOUNT);
        TwitterSubscriptionSystem subscriptionSystem = new TwitterSubscriptionSystem();
        TwitterAccount account = new TwitterAccount("Celebrity");

        IntStream.range(0, NEW_SUBSCRIBERS_AMOUNT)
                .mapToObj(i -> subscriptionSystem.followAccount(account, threadPool))
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        futures -> CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))))
                .join();
        log.info("Account name {} has {} followers", account.getUsername(), account.getFollowers());

        shutdownWithWaiting(threadPool, AWAIT_TERMINATION_SECONDS);
    }

    private static void shutdownWithWaiting(ExecutorService threadPool, int terminationTime) {
        threadPool.shutdown();
        try {
            if (!threadPool.awaitTermination(terminationTime, TimeUnit.SECONDS)) {
                log.warn("Tasks did not completed, shutdownNow");
                threadPool.shutdownNow();
            } else {
                log.info("All tasks completed");
            }
        } catch (InterruptedException e) {
            log.warn("Thread {} was interrupted", Thread.currentThread().getName());
            Thread.currentThread().interrupt();
        }
    }
}
