package faang.school.godbless;

import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {

    public void addFollower(TwitterAccount twitterAccount){
        synchronized (twitterAccount){
            twitterAccount.setFollowers(twitterAccount.getFollowers()+1);
        }
    }

    public CompletableFuture<Void> followAccount(TwitterAccount twitterAccount){
        return CompletableFuture.runAsync(() -> addFollower(twitterAccount));
    }


}
