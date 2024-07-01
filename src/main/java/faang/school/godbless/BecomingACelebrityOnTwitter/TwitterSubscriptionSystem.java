package faang.school.godbless.BecomingACelebrityOnTwitter;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class TwitterSubscriptionSystem {
    private static final int THREAD_SLEEP = 1000;
    private static final int NUM_THREADS = 13;
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(NUM_THREADS);
    private static final Random random = new Random();
    private static final List<CompletableFuture<Integer>> allTwitterSubSystemFuture = new ArrayList<>();

    public static void addFollower(TwitterAccount twitterAccount) {
        CompletableFuture<Integer> addFollowerFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(random.nextInt(THREAD_SLEEP));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            twitterAccount.getFollowers().incrementAndGet();
            return 1;
        }).exceptionally(ex -> {
            log.error(".sleep in addFollower method was interrupted while waiting");
            return -1;
        });
        allTwitterSubSystemFuture.add(addFollowerFuture);
    }

    public static void waitGettingAllNewFollowers() {
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(allTwitterSubSystemFuture.toArray(new CompletableFuture[0]));
        allFutures.join();
    }

    public static void shutdownTwitterSubscriptionSystem() {
        EXECUTOR.shutdown();
    }
}
