package faang.school.godbless.sprint3.twitterCelebrity;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

public class TwitterSubscriptionSystem {

    private final ExecutorService executorService;

    public TwitterSubscriptionSystem(ExecutorService executorService) {
        this.executorService = executorService;
    }

    public void addFolLower(TwitterAccount twitterAccount) {
        twitterAccount.addFollower();
    }

    public CompletableFuture<Void> followAccount(TwitterAccount twitterAccount) {
        return CompletableFuture.runAsync(() -> {
            synchronized (twitterAccount.getLock()) {
                addFolLower(twitterAccount);
            }
        }, executorService);
    }
}
