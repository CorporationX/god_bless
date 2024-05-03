package faang.school.godbless.twitter_celebrity;

import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {

    public void addFollower(TwitterAccount twitterAccount){
        twitterAccount.changeFollowersCount();
    }

    public CompletableFuture<Void> followAccount(TwitterAccount twitterAccount){
        return CompletableFuture.runAsync(() -> addFollower(twitterAccount));
    }
}
