package school.faang.task416.twitter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TwitterSubscriptionSystem {
    private synchronized void addFollower(TwitterAccount account) {
        account.incrementFollowers();
    }

    private List<CompletableFuture<Void>> listOfFutures = new ArrayList<>();

    public boolean isAllTaskDone() {
        CompletableFuture<Void> completableFuture = CompletableFuture.allOf(listOfFutures.toArray(new CompletableFuture[0]));
        return completableFuture.isDone();
    }

    public void followAccount(TwitterAccount account) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        listOfFutures.add(CompletableFuture.runAsync(() -> addFollower(account), service));
        service.shutdown();
    }
}
