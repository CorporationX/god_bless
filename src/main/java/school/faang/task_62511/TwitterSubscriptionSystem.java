package school.faang.task_62511;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class TwitterSubscriptionSystem {
    private static final int ONE_FOLLOWER = 1;

    public CompletableFuture<TwitterAccount> followAccount(TwitterAccount account) {
        String username = account.getUsername();
        ExecutorService executor = Executors.newSingleThreadExecutor();

        CompletableFuture<TwitterAccount> accountFuture = CompletableFuture.supplyAsync(() -> {
            log.info(TwitterSubscriptionMessage.START_ACCOUNT_FOLLOW.getMessage(), username);
            addFollower(account);
            log.info(TwitterSubscriptionMessage.END_ACCOUNT_FOLLOW.getMessage(), username);
            return account;
        }, executor);

        executor.shutdown();

        return accountFuture;
    }

    private synchronized void addFollower(TwitterAccount account) {
        account.setFollowers(account.getFollowers() + ONE_FOLLOWER);
    }
}
