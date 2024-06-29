package faang.school.godbless.BJS2_14161;

import lombok.Getter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Getter
public class TwitterSubscriptionSystem {
    public static final ExecutorService EXECUTOR = Executors.newCachedThreadPool();

    synchronized public void addFollower(TwitterAccount twitterAccount) {
        twitterAccount.setFollowers(twitterAccount.getFollowers() + 1);
    }

    public CompletableFuture<Void> followAccount(TwitterAccount twitterAccount) {
        return CompletableFuture.runAsync(() -> addFollower(twitterAccount), EXECUTOR);
    }
}
