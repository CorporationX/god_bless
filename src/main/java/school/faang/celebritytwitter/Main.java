package school.faang.celebritytwitter;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Main {
    private static final int FOLLOWERS_COUNT = 200_000_000;

    public static void main(String[] args) {
        TwitterSubscriptionSystem twitterSubscription = new TwitterSubscriptionSystem();
        TwitterAccount lovelyMentor = new TwitterAccount("Rinat", new AtomicInteger(0));

        CompletableFuture.allOf(CompletableFuture.runAsync(() -> {
            for (int i = 0; i < FOLLOWERS_COUNT; i++) {
                twitterSubscription.followAccount(lovelyMentor);
            }
        })).join();

        log.info(String.valueOf(lovelyMentor.getFollowers()));
    }
}