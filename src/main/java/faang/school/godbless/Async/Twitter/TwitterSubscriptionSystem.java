package faang.school.godbless.Async.Twitter;

import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {
    public synchronized int addFollower(TwitterAccount account) {
        account.setFollowers(account.getFollowers() + 1);
        return account.getFollowers();
    }

    public CompletableFuture<Integer> followAccount(TwitterAccount account) {
        CompletableFuture<Integer> future = new CompletableFuture<>();
        future.complete(addFollower(account));
        return future;
    }
}
