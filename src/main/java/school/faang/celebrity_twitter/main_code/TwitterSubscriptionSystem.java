package school.faang.celebrity_twitter.main_code;

import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {
    public synchronized void addFollowerAccount(TwitterAccount account){
        account.setFolowers(account.getFolowers() + 1);
    }

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> addFollowerAccount(account));
    }
}
