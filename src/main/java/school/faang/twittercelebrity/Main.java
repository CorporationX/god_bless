package school.faang.twittercelebrity;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
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
                        .runAsync(() -> SUBSCRIPTION_SYSTEM.followAccount(MY_ACCOUNT), EXECUTOR)
                        .orTimeout(TIME_EXECUTION, TIME_UNIT));
            }

            CompletableFuture.allOf(FUTURES.toArray(CompletableFuture[]::new)).join();
            log.info("Total account {} followers: {}", MY_ACCOUNT.username(), MY_ACCOUNT.followers());
            EXECUTOR.shutdown();
        } catch (CompletionException e) {
            log.error("Execution timed out {} {}", TIME_EXECUTION, TIME_UNIT);
            EXECUTOR.shutdownNow();
        }
    }
}
