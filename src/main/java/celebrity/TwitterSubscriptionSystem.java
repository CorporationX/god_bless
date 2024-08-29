package celebrity;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class TwitterSubscriptionSystem {
    private final Map<TwitterAccount, Object> accountLocks = new HashMap<>();

    public CompletableFuture<Void> followAccount(@NonNull TwitterAccount account) {
        return CompletableFuture.runAsync(() -> addFollower(account));
    }

    public void addFollower(@NonNull TwitterAccount account) {
        addLock(account);
        synchronized (accountLocks.get(account)) {
            account.addFollower();
        }
        log.info(account.getUsername() + " get new follower!");
    }

    private synchronized void addLock(@NonNull TwitterAccount account) {
        if (accountLocks.containsKey(account)) {
            return;
        }
        accountLocks.put(account, new Object());

    }
}
