package school.faang.task_51003;

import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {

    private void addFollower(TwitterAccount account) {
        account.addFollower();
    }

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> addFollower(account));
    }
}