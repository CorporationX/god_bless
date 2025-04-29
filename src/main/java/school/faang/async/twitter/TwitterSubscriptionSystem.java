package school.faang.async.twitter;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class TwitterSubscriptionSystem {

    public void followAccount(TwitterAccount account) {
        CompletableFuture.runAsync(() -> addFollower(account)).join();
    }

    private void addFollower(TwitterAccount account) {
        account.getFollowers().addAndGet(1);
    }

}
