package faang.school.godbless.FourthSprint.bjs2_51053;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TwitterSubscriptionSystem {

    private final ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public void addFollower(TwitterAccount account) {
        account.getFollowers().incrementAndGet();
    }

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> addFollower(account), executor);
    }

    public void executorShutdown() {
        executor.shutdown();
    }
}
