package faang.school.godbless.celebrity_twitter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int THREADS = 5;
    private static final int FOLLOWERS = 10_000;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREADS);

        TwitterAccount account = new TwitterAccount("Rauan");
        TwitterSubscriptionSystem subscriptionSystem = new TwitterSubscriptionSystem();

        List<CompletableFuture<Void>> completableFutures = new ArrayList<>();

        for (int i = 0; i < FOLLOWERS; i++) {
            completableFutures.add(subscriptionSystem.followAccount(account, executorService));
        }

        CompletableFuture.allOf(completableFutures.toArray(CompletableFuture[]::new)).join();

        executorService.shutdown();

        System.out.printf("Total %s followers: %s", account.getName(), account.getFollowers());
    }
}
