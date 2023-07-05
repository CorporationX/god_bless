package faang.school.godbless.sprint5.Multithreading_Async.task11_twitter;

import lombok.SneakyThrows;

import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {

    @SneakyThrows
    public CompletableFuture<Void> followAccount(TwitterAccount twitterAccount) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            addFollower(twitterAccount);
        });
    }

    private synchronized void addFollower(TwitterAccount twitterAccount) {
        twitterAccount.setFollowers(twitterAccount.getFollowers() + 1);
    }
}
