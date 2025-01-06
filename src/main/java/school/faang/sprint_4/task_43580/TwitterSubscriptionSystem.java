package school.faang.sprint_4.task_43580;

import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {
    private synchronized void addFolLower(TwitterAccount account) {
        account.setFollowers(account.getFollowers() + 1);
    }

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> {
            addFolLower(account);
        });
    }
}