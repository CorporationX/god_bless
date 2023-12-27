package faang.school.godbless.multi_asyn.task8twitter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TwitterSubscriptionSystem {
    private final Object lock = new Object();
    ExecutorService executorService = Executors.newCachedThreadPool();

    private synchronized void addFollower(TwitterAccount account) {
        account.setFollowers(account.getFollowers() + 1);
    }

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            addFollower(account);
        }, executorService);
    }

    public void endProcess() {
        executorService.shutdown();
    }
}
