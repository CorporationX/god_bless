package faang.school.godbless.twitter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.locks.ReentrantLock;

public class TwitterSubscriptionSystem {

    ReentrantLock lock = new ReentrantLock(true);

    private void addFollower(TwitterAccount twitterAccount) {
        CompletableFuture.runAsync(() -> twitterAccount.getFollowers().incrementAndGet());
    }

    public void followAccount(TwitterAccount twitterAccount) {
        lock.lock();
        try {
            addFollower(twitterAccount);
        } finally {
            lock.unlock();
        }

    }
}
