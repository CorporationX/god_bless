package school.faang.BJS2_39199;

import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {
    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(account::addFollower);
    }

    public void processSubscriptions(TwitterAccount account, int numberOfFollowers) {
        CompletableFuture<?>[] tasks = new CompletableFuture[numberOfFollowers];
        for (int i = 0; i < numberOfFollowers; i++) {
            tasks[i] = followAccount(account);
        }

        CompletableFuture.allOf(tasks).join();
        System.out.printf(" тоговое количество подписчиков у %s: %d \n", account.getUsername(), account.getFollowers());
    }
}
