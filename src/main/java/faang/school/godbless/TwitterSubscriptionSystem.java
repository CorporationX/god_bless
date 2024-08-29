package faang.school.godbless;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TwitterSubscriptionSystem {

    private final ExecutorService executorService;
    public TwitterSubscriptionSystem(int threadSize){
        executorService = Executors.newFixedThreadPool(threadSize);
    }
    synchronized void addFollower(TwitterAccount account) {
        account.setFollowers( account.getFollowers() + 1);
    }

    CompletableFuture<Void> followAccount(TwitterAccount account) {
        CompletableFuture<Void> futureResult = CompletableFuture.runAsync(() -> addFollower(account),executorService);
        return futureResult;
    }

    public void shutDown(){
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(1, TimeUnit.MINUTES)){
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
