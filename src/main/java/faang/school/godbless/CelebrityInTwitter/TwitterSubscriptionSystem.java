package faang.school.godbless.CelebrityInTwitter;

import lombok.Getter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TwitterSubscriptionSystem {
    private static final int COUNT_THREAD = 6;
    @Getter
    private ExecutorService executorService = Executors.newFixedThreadPool(COUNT_THREAD);

    public CompletableFuture<Void> followAccount(TwitterAccount twitterAccount) {
        return CompletableFuture.runAsync(() -> addFollower(twitterAccount), executorService);
    }

    private void addFollower(TwitterAccount twitterAccount) {
        twitterAccount.getFollowers().incrementAndGet();
    }
}
