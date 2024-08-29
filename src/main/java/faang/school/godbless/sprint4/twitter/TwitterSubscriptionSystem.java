package faang.school.godbless.sprint4.twitter;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@RequiredArgsConstructor
@Getter
public class TwitterSubscriptionSystem {
    public synchronized void addFollower(TwitterAccount account) {
        account.setFollowers(account.getFollowers() + 1);
    }

    public CompletableFuture<Void> followAccount(TwitterAccount account, ExecutorService executor) {
        return CompletableFuture
                .runAsync(() -> addFollower(account), executor)
                .thenRun(() -> System.out.printf("Account %s has one more follower%n", account.getUsername()));
    }
}
