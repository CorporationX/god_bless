package faang.school.godbless.mt.twitter;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    public static void main(String[] args) {
        TwitterAccount account1 = new TwitterAccount("Bob");
        TwitterAccount account2 = new TwitterAccount("Carl");

        TwitterSubscriptionSystem subscriptionSystem = new TwitterSubscriptionSystem();

        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            futures.add(subscriptionSystem.followAccount(account1));
            futures.add(subscriptionSystem.followAccount(account2));
        }

        CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new)).join();
        log.info("Bob followers count = {}", account1.getFollowers());
        log.info("Carl followers count = {}", account2.getFollowers());
        subscriptionSystem.shutdown();
    }
}
