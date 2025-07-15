package school.faang.twittercelebrity;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class TwitterSystem {
    private static final int THREAD_COUNT = 4;
    private static final ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);

    public static void addFollower(TwitterAccount account) {
        account.incrementFollowers();
    }

    public static CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> addFollower(account), executor);
    }

    public static CompletableFuture<Void> followMany(TwitterAccount account, int count) {
        List<CompletableFuture<Void>> tasks = IntStream.range(0, count)
                .mapToObj(i -> followAccount(account))
                .toList();
        return CompletableFuture.allOf(tasks.toArray(new CompletableFuture[0]));
    }

    public static void close() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(2, TimeUnit.SECONDS)) {
                log.info("Shutting down executor");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Thread was interrupted", e);
            throw new RuntimeException("Thread was interrupted", e);
        }
    }
}
