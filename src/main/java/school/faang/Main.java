package school.faang;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int THREAD_POOL_SIZE = 3;
    private static final ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

    public static void main(String[] args) {
        TwitterSubscriptionSystem subscriptionSystem = new TwitterSubscriptionSystem();
        TwitterAccount account = new TwitterAccount("user");
        List<CompletableFuture<Void>> futures = new ArrayList<>();

        for (int i = 0; i < 15; ++i) {
            futures.add(subscriptionSystem.followAccount(account, executor));
        }
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        executor.shutdown();
    }
}
