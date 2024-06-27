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
    private static final Random random = new Random();
    private static final int NUM_THREADS = 13;
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(NUM_THREADS);
    private final static List<CompletableFuture<Void>> allTwitterSubSystemFuture = new ArrayList<>();

    public static void addFollower(TwitterAccount twitterAccount) {
        CompletableFuture<Void> addFollowerFuture = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            twitterAccount.getFollowers().incrementAndGet();
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
