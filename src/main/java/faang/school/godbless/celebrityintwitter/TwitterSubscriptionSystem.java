package faang.school.godbless.celebrityintwitter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TwitterSubscriptionSystem {

    private final int N_THREADS = 20;
    private final ExecutorService executorService = Executors.newFixedThreadPool(N_THREADS);

    public static void main(String[] args) {
        TwitterSubscriptionSystem subscriptionSystem = new TwitterSubscriptionSystem();
        TwitterAccount account = new TwitterAccount("Umirayu");

        subscriptionSystem.followAccount(account);
    }

    public synchronized void addFollower(TwitterAccount account) {
        account.incrementFollowers();
    }

    public void followAccount(TwitterAccount account) {
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            futures.add(CompletableFuture.runAsync(() -> addFollower(account), executorService));
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[]{}))
                .thenRun(() -> System.out.println(account.getFollowers()))
                .join();

        executorService.shutdown();
    }
}
