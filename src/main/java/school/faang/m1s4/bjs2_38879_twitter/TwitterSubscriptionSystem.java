package school.faang.m1s4.bjs2_38879_twitter;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class TwitterSubscriptionSystem {
    private static final int N_POOLS = 5;
    private static final int TERMINATION_TIME = 300;
    private final ExecutorService serviceFixedPool = Executors.newFixedThreadPool(N_POOLS);

    public void addManyFollowers(int numFollowers, TwitterAccount account) {
        List<CompletableFuture<Void>> futures = new ArrayList<>();

        for (int i = 1; i < numFollowers + 1; i++) {
            System.out.printf("%d : %s : Follower #%d wants to follow %s%n",
                    Thread.currentThread().getId(), LocalTime.now(), i, account.getUsername());
            futures.add(followAccount(account));
        }
        CompletableFuture<Void> allTasksDone = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        shutdownPool();

        System.out.println();
        allTasksDone.thenRun(() -> System.out.printf("%d : %s : Session ended. Total followers: %d%n",
                Thread.currentThread().getId(), LocalTime.now(), account.getFollowers()));
    }

    private CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> addFollower(account), serviceFixedPool);
    }

    private void addFollower(TwitterAccount account) {
        int followersUpdate = account.incrementFollowers();
        System.out.printf("%d : %s New follower added. Total followers: %d%n",
                Thread.currentThread().getId(), LocalTime.now(), followersUpdate);
    }

    private void shutdownPool() {
        serviceFixedPool.shutdown();
        try {
            if (!serviceFixedPool.awaitTermination(TERMINATION_TIME, TimeUnit.SECONDS)) {
                serviceFixedPool.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Thread has been interrupted", e);
        }
    }
}
