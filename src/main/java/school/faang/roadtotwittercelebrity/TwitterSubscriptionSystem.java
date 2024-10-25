package school.faang.roadtotwittercelebrity;

import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {

    public synchronized void addFollower(TwitterAccount account) {
        account.setFollowers(account.getFollowers() + 1);
        System.out.println("Новый подписчик - "+ Thread.currentThread().getName());
    }

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> {addFollower(account);});
    }
}
