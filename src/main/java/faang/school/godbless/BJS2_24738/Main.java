package faang.school.godbless.BJS2_24738;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        final int NUM_THREADS = 100;
        final int FOLLOWERS_COUNT = 2000;
        TwitterAccount twitterAccount = new TwitterAccount("Someone", 5);
        TwitterSubscriptionSystem twitterSubscriptionSystem = new TwitterSubscriptionSystem();
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        CompletableFuture<Void> combined = CompletableFuture.allOf(
                IntStream.range(1, FOLLOWERS_COUNT + 1)
                        .mapToObj(x -> twitterSubscriptionSystem.followAccount(twitterAccount, executor))
                        .toArray(CompletableFuture[]::new));
        combined.join();
        System.out.println("Followers count: " + twitterAccount.getFollowers());

        try {
            executor.shutdown();
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
