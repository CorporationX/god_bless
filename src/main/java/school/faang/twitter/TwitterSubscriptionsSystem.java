package school.faang.twitter;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class TwitterSubscriptionsSystem {
    private static final ExecutorService THREAD_POOL = Executors.newFixedThreadPool(5);

    private final Object lock = new Object();

    public void addFollower(TwitterAccount twitterAccount){
        synchronized (lock){
            twitterAccount.setFollowers(twitterAccount.getFollowers() + 1);
        }
    }

    public CompletableFuture<Void> followAccount(TwitterAccount twitterAccount){
        return CompletableFuture.runAsync(() -> addFollower(twitterAccount), THREAD_POOL);
    }
}
