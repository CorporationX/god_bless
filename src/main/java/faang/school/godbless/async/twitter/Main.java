package faang.school.godbless.async.twitter;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {

    private static final int SUBSCRIBERS_COUNT = 20;

    public static void main(String[] args) {
        var system = new TwitterSubscriptionSystem();
        var account = new TwitterAccount("example");

        var futures = new CompletableFuture[SUBSCRIBERS_COUNT];
        for (int i = 0; i < SUBSCRIBERS_COUNT; i++) {
            futures[i] = system.followAccount(account);
        }

        CompletableFuture.allOf(futures).join();
        log.info("Number of followers: {}", account.getFollowers());
    }
}
