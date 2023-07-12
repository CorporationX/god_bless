package faang.school.godbless.sprint_3.multithreading_future.twitter_celebrity;

import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {
    public void addFollower(TwitterAccount account) {
        account.getFollowers().incrementAndGet();
    }

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> {
            System.out.printf("На ваш аккаунт: %s подписался еще один человек%n", account.getUsername());
            addFollower(account);
        });
    }
}