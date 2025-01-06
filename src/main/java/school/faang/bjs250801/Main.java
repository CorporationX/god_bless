package school.faang.bjs250801;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int THREAD_AMOUNT = 20;
    private static final int FOLLOWERS_AMOUNT = 200;
    private static final int AWAIT_TIME = 5;

    public static void main(String[] args) {
        TwitterAccount account = new TwitterAccount("Jam");
        TwitterSubscriptionSystem subscriptionSystem = new TwitterSubscriptionSystem();

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_AMOUNT);

        IntStream.range(0, FOLLOWERS_AMOUNT)
                .mapToObj(i -> subscriptionSystem.followAccount(account, executorService))
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        futures -> CompletableFuture
                                .allOf(futures.toArray(new CompletableFuture[0]))))
                .join();

        log.info("Now account {} has {} followers", account.getUsername(), account.getFollowers());

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(AWAIT_TIME, TimeUnit.SECONDS)) {
                log.info("The tasks were not completed in 5 seconds, stoped the ThreadPool forcefully");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("The main thread {} was interrupted while waiting",
                    Thread.currentThread().getName());
            Thread.currentThread().interrupt();
        }
    }
}