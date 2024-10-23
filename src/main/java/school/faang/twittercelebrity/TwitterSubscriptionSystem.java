package school.faang.twittercelebrity;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

public class TwitterSubscriptionSystem {

    private synchronized void addFollower(TwitterAccount account) {
        account.setFollowers(account.getFollowers() + 1);
        System.out.println("Account: " + account.getUsername() + "has now " + account.getFollowers() + " followers");
    }

    public CompletableFuture<Void> followAccount(TwitterAccount account, ExecutorService executor) {
        return CompletableFuture.runAsync(() -> addFollower(account), executor);
    }
}
