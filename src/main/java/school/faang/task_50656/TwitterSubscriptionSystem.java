package school.faang.task_50656;

import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {
    public int addFollower(TwitterAccount account) {
        if (account == null) {
            throw new IllegalArgumentException("Something went wrong : 6, TwitterSubscriptionSystem");
        }
        return account.getFollowers().incrementAndGet();
    }

    public CompletableFuture<Integer> followAccount(TwitterAccount account) {
        if (account == null) {
            throw new IllegalArgumentException("Something went wrong : 13, TwitterSubscriptionSystem");
        }
        return CompletableFuture.supplyAsync(() -> addFollower(account));
    }
}
