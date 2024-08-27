package faang.school.godbless.BJS2_24668;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class TwitterSubscriptionSystem {
    private static final int NUM_THREADS = 15;
    private static ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
    private  void addFollower(TwitterAccount twitterAccount){
        twitterAccount.addFollower();
        log.info("Follower added. Now: {}", twitterAccount.getFollowers());
    }

    public CompletableFuture<Void> followAccount(TwitterAccount twitterAccount){
        return CompletableFuture.runAsync(() -> addFollower(twitterAccount), executorService);
    }

    public void shutdown(){
        executorService.shutdown();
    }
}
