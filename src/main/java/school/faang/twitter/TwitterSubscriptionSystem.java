package school.faang.twitter;

import org.ietf.jgss.Oid;

import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {
    public void addFollowers(TwitterAccount account) {
        synchronized (account) {
            account.setFollowers(account.getFollowers() + 1);
        }
    }

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> addFollowers(account));
    }
}
