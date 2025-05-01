package school.faang.async.twitter;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class TwitterSubscriptionSystem {

    public CompletableFuture<Integer> followAccount(TwitterAccount account) {
        return CompletableFuture.supplyAsync(() -> addFollower(account));
    }

    private Integer addFollower(TwitterAccount account) {
        return account.getFollowers().addAndGet(1);
    }

}
