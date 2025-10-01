package school.faang.bjs293172;

import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {

    public synchronized void addFollower(TwitterAccount account) {
        account.setFollowers(account.getFollowers() + 1);
    }

    public void followAccount(TwitterAccount account) {
        CompletableFuture.supplyAsync(
            () -> {
                addFollower(account);
                return account;
            }
        ).thenAccept(followedAccount ->
            System.out.println("You are now following " + followedAccount.getUsername())
        );
    }
}