package faang.school.godbless.BJS2_1354;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

public class TwitterSubscriptionSystem {
    public CompletableFuture<Void> followAccount(TwitterAccount account, ExecutorService executor) {
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            synchronized (account) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                account.addFollower();
            }
        }, executor);
        return completableFuture.thenRun(executor::shutdown);
    }
}