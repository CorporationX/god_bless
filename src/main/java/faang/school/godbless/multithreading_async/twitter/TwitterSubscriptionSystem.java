package faang.school.godbless.multithreading_async.twitter;

import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {

    public static synchronized void addFollower(TwitterAccount twitterAccount){
        twitterAccount.setFollowers(twitterAccount.getFollowers() + 1);
    }

    public static CompletableFuture<Void> followAccount(TwitterAccount twitterAccount){
        return CompletableFuture.runAsync(() -> addFollower(twitterAccount));
    }
}
