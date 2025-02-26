package school.faang.twittercelebrity;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final TwitterSubscriptionSystem SUBSCRIPTION_SYSTEM = new TwitterSubscriptionSystem();
    private static final ExecutorService EXECUTOR =
            Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    private static final List<CompletableFuture<Void>> FUTURES = new ArrayList<>();
    private static final TwitterAccount MY_ACCOUNT = new TwitterAccount("Yom");
    private static final int TOTAL_FOLLOWERS = 1000000;
    private static final int TIME_EXECUTION = 1;
    private static final TimeUnit TIME_UNIT = TimeUnit.MINUTES;

    public static void main(String[] args) {
        try {
            for (int i = 0; i < TOTAL_FOLLOWERS; i++) {
                FUTURES.add(CompletableFuture
                        .runAsync(() -> SUBSCRIPTION_SYSTEM.followAccount(MY_ACCOUNT), EXECUTOR));
            }

            CompletableFuture.allOf(FUTURES.toArray(CompletableFuture[]::new)).join();

            EXECUTOR.shutdown();
            if (EXECUTOR.awaitTermination(TIME_EXECUTION, TIME_UNIT)) {
                log.info("Total account {} followers: {}", MY_ACCOUNT.getUsername(), MY_ACCOUNT.getFollowers());
            } else {
                log.warn("Timed out {} {}", TIME_EXECUTION, TIME_UNIT);
                EXECUTOR.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Thread interrupted name: {}\nException: {}\n{}",
                    Thread.currentThread().getName(), e, e.getStackTrace());
            Thread.currentThread().interrupt();
            EXECUTOR.shutdownNow();
        }

    }
}
