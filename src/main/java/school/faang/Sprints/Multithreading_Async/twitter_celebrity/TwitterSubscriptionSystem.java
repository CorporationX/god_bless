package school.faang.Sprints.Multithreading_Async.twitter_celebrity;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TwitterSubscriptionSystem {

    private synchronized static void addFollower(@NonNull TwitterAccount account) {
        try {
            Thread.sleep(2_000);
            account.getFollowers().incrementAndGet();
            System.out.println(Thread.currentThread().getName() + " add follower");
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

    public static void followAccount(TwitterAccount account) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<CompletableFuture<Void>> completableFutures = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            completableFutures.add(CompletableFuture.runAsync(() -> addFollower(account), executor));
        }

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(
                completableFutures.toArray(new CompletableFuture[0]));

        allFutures.thenRun(() -> {
            System.out.println(String.format("Followers of %s = %d", account.getUsername(), account.getFollowers().get()));
        }).join();
        executor.shutdown();
    }
}
