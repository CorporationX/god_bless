package school.faang.task_51690;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {
    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> {
            account.addFollower();
            System.out.println("Added a follower to " + account.getUsername()
                    + ". Total followers: " + account.getFollowers());
        });
    }

    public void processSubscriptions(TwitterAccount account, int numberOfFollowers) {
        List<CompletableFuture<Void>> futures = new ArrayList<>();

        for (int i = 0; i < numberOfFollowers; i++) {
            futures.add(followAccount(account));
        }

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        allTasks.thenRun(() -> System.out.println("Final follower count for "
                + account.getUsername() + ": " + account.getFollowers())).join();
    }
}
