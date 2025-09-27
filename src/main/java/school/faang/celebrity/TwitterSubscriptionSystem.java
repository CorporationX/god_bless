package school.faang.celebrity;

import lombok.NoArgsConstructor;

import java.util.concurrent.CompletableFuture;

@NoArgsConstructor
public class TwitterSubscriptionSystem {
    public synchronized void addFollower(TwitterAccount account) {
        account.setFollowers(account.getFollowers() + 1);
    }

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> {
            addFollower(account);
        });
    }
}
