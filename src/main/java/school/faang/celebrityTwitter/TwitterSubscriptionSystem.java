package school.faang.celebrityTwitter;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@Getter
public class TwitterSubscriptionSystem {
    final int THREADS = 5;
    private ExecutorService executor = Executors.newFixedThreadPool(THREADS);
    public synchronized void addFollower(TwitterAccount acc){
            acc.setFollowers(acc.getFollowers() + 1);
            log.info("Всего подписчиков" + acc.getFollowers());
    }

    public CompletableFuture<Void> followAccount(TwitterAccount acc){
        return CompletableFuture.runAsync(() -> {
            addFollower(acc);
        }, executor);
    }

}
