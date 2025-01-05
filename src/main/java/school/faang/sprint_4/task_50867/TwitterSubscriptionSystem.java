package school.faang.sprint_4.task_50867;

import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {
    private void addFollower(TwitterAccount account) {
        account.addFollower();
    }

    public void followAccount(TwitterAccount account) {
        CompletableFuture.runAsync(() -> addFollower(account));
    }
}
