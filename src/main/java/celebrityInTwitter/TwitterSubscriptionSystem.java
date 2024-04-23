package celebrityInTwitter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TwitterSubscriptionSystem {
    private void addFollower(TwitterAccount account) {
        checkAccount(account);
        account.getFollowers().incrementAndGet();
    }

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        checkAccount(account);
        ExecutorService service = Executors.newCachedThreadPool();
        CompletableFuture<Void> accountAfterFollow = CompletableFuture.runAsync(() -> addFollower(account), service);
        service.shutdown();
        return accountAfterFollow;
    }

    private void checkAccount(TwitterAccount account) {
        if (account == null) {
            throw new NullPointerException("Account must be exist");
        }
    }
}
