package faang.school.godbless.BJS2_24868;

import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {

    public synchronized void addFollower(TwitterAccount twitterAccount){
        twitterAccount.setFollowers(twitterAccount.getFollowers() + 1);
    }

    public CompletableFuture<TwitterAccount> followAccount(TwitterAccount twitterAccount){
        return CompletableFuture.supplyAsync(() -> {
            addFollower(twitterAccount);
            return twitterAccount;
        });
    }
}
