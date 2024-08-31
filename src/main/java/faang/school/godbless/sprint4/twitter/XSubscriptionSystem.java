package faang.school.godbless.sprint4.twitter;

import java.util.concurrent.CompletableFuture;

public class XSubscriptionSystem {
    private final Object lock = new Object();

    public CompletableFuture<Void> followAccount(XAccount account) {
        return CompletableFuture.runAsync(() -> {
            synchronized(lock) {
                addFollower(account);
            }
        });
    }

    private void addFollower(XAccount account) {
        account.incrementFollowers();
    }
}
