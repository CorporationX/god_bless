package school.faang.BJS2_62471;

import lombok.NonNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class TwitterSubscriptionSystem {
    private static final int THREAD_AMOUNT = 5;
    private static final int SUBSCRIBER_AMOUNT = 10_000_000;

    public static void addFollower(@NonNull TwitterAccount account) {
        account.getFollowers().incrementAndGet();
    }

    public static CompletableFuture<Void> followAccount(@NonNull TwitterAccount account, @NonNull Executor executor) {
        return CompletableFuture.runAsync(() -> addFollower(account), executor);
    }

    public static void main(String[] args) {
        TwitterAccount account = new TwitterAccount("My account", new AtomicInteger(0));
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_AMOUNT);
        List<CompletableFuture<Void>> futures = IntStream.range(0, SUBSCRIBER_AMOUNT)
                .mapToObj(i -> followAccount(account, executor))
                .toList();
        CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new))
                .thenRun(() -> System.out.println("Number of subscribers: %d".formatted(account.getFollowers().get())))
                .exceptionally(throwable -> {
                    System.err.println("Error: " + throwable.getMessage());
                    return null;
                })
                .join();

        try {
            executor.shutdown();
        } catch (SecurityException e) {
            System.err.println("Failed to shutdown executor due to security restrictions: " + e.getMessage());
            return;
        }

        try {
            if (!executor.awaitTermination(100, TimeUnit.SECONDS)) {
                System.err.println("Executor did not terminate in 10 seconds, forcing shutdown...");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.err.println("Await termination interrupted: " + e.getMessage());
            Thread.currentThread().interrupt();
            executor.shutdownNow();
        }
    }
}
