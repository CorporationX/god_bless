package faang.school.godbless.celebrity_in_twitter;

import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {

    public synchronized void addFollower(TwitterAccount account, int count) {
        for (int i = 0; i < count; i++) {
            account.setFollowers(account.getFollowers() + 1);
        }

        System.out.println(account.getUsername() + " amount followers " + account.getFollowers());
    }

    public CompletableFuture<Void> followAccount(TwitterAccount account, int count) {
        return CompletableFuture.runAsync(() -> {
            addFollower(account, count);
        });
    }
}
