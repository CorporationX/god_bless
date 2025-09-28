package school.faang.bjs2_93039;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TwitterSubscriptionSystem {
    private static final int THREAD_COUNT = 5;
    ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);

    public synchronized int addFollower(TwitterAccount account) {
        int increasedFollowersCount = account.getFollowers() + 1;
        account.setFollowers(increasedFollowersCount);
        System.out.printf("One more follower has been added to account %s\n", account.getUsername());
        return increasedFollowersCount;
    }

    public CompletableFuture<Integer> followAccount(TwitterAccount twitterAccount) {
        return CompletableFuture.supplyAsync(() -> addFollower(twitterAccount), executorService);
    }

    public void shutdownExecutorService() {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(1, TimeUnit.SECONDS)) {
                System.out.println("Executor Service can't stop");
                executorService.shutdownNow();
                if (!executorService.awaitTermination(1, TimeUnit.SECONDS)) {
                    System.out.println("Executor Service can't stop even with shutdownNow().");
                    executorService.shutdownNow();
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupt");
            executorService.shutdown();
        }
    }
}
