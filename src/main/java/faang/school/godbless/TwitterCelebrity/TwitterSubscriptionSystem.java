package faang.school.godbless.TwitterCelebrity;

import lombok.RequiredArgsConstructor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@RequiredArgsConstructor
public class TwitterSubscriptionSystem {
    private final ExecutorService poll;

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> addFollower(account), poll);
    }

    private void addFollower(TwitterAccount account) {
        account.getFollowers().incrementAndGet();
    }
}
