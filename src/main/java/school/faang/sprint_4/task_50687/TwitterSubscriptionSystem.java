package school.faang.sprint_4.task_50687;

import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {

    private void addFollower(TwitterAccount account) {
        account.addFollower();
    }

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> addFollower(account));
    }
}
