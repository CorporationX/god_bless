package faang.school.godbless.BJS2_24693;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {

    private static final int THREAD_POOL_SIZE = 5;
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
    private static final int FOLLOWERS_TO_FOLLOW = 10;

    public static void main(String[] args) {

        TwitterSubscriptionSystem twitterSubscriptionSystem = new TwitterSubscriptionSystem();
        TwitterAccount wayne = new TwitterAccount("@wayne");
        TwitterAccount kent = new TwitterAccount("@kent");

        List<CompletableFuture<Void>> futures = new ArrayList<>();

        for (int i = 0; i < FOLLOWERS_TO_FOLLOW; i++) {
            futures.add(twitterSubscriptionSystem.followAccount(wayne, EXECUTOR));
            futures.add(twitterSubscriptionSystem.followAccount(kent, EXECUTOR));
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenRun(() -> {
                    System.out.println("Followers followed to " + wayne.getName() + ": " + wayne.getFollowersCount());
                    System.out.println("Followers followed to " + kent.getName() + ": " + kent.getFollowersCount());
                })
                .join();

        EXECUTOR.shutdown();

        try {
            if (EXECUTOR.awaitTermination(5, TimeUnit.MINUTES)) {
                System.out.println("All followers followed");
            } else {
                EXECUTOR.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
