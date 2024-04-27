package faang.school.godbless.BJS2_6138;

import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {

    // я думаю что это можно было бы решить при помощи использования AtomicInteger
    // если у нас решит 1_000_000 человек подписаться сразу тогда нам придется ждать 11 дней (секунды в дни перевел) 😀
    public synchronized void addFollower(TwitterAccount twitterAccount) {
        twitterAccount.setFollowers(twitterAccount.getFollowers() + 1);
    }

    public CompletableFuture<Void> followAccount(TwitterAccount twitterAccount) {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return CompletableFuture.runAsync(() -> addFollower(twitterAccount));
    }
}
