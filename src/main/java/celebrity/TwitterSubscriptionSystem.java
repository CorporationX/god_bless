package celebrity;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class TwitterSubscriptionSystem {
    private static final int POOL_SIZE = 100;
    private final ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE);
    private final Map<TwitterAccount, Object> accountLocks = new HashMap<>();

    public CompletableFuture<Void> followAccount(@NonNull TwitterAccount account) {
        return CompletableFuture.runAsync(() -> addFollower(account), executor);
    }

    public void addFollower(@NonNull TwitterAccount account) {
        if (!accountLocks.containsKey(account)) {
            addLock(account);
        }
        synchronized (accountLocks.get(account)) {
            account.addFollower();
        }
        log.info(account.getUsername() + " get new follower!");
    }

    public void shutdownService() {
        executor.shutdown();
    }

    private synchronized void addLock(@NonNull TwitterAccount account) {
        if (accountLocks.containsKey(account)) {
            return;
        }
        accountLocks.put(account, new Object());

    }
}
