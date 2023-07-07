package faang.school.godbless.sprint5.becomeCelebrity.classes;

import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {

    private synchronized void addFollower(TwitterAccount account) {
        account.setFollowers(account.getFollowers() + 1);
    }

    public CompletableFuture<TwitterAccount> followAccount(TwitterAccount account) {
        return CompletableFuture.supplyAsync(() -> {
            addFollower(account);
            return account;
        });
    }
}
