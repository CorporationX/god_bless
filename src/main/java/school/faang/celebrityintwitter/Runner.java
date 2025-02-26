package school.faang.celebrityintwitter;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Runner {
    private static final int SUBSCRIBERS = 10;

    public static void main(String[] args) {
        TwitterAccount account = new TwitterAccount("Vlad", new AtomicInteger(0));
        TwitterSubscriptionSystem system = new TwitterSubscriptionSystem();
        CompletableFuture.allOf(
                CompletableFuture.runAsync(() -> {
                    for (int i = 0; i < SUBSCRIBERS; i++) {
                        system.followAccount(account);
                    }
                })
        ).join();
        log.info("Subscribers in account {}", account.getFollowers());
    }
}
