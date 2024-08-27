package faang.school.godbless.becomingacelebrity;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    public static void main(String[] args) {
        TwitterAccount jack = new TwitterAccount("Jack Dorsey");
        TwitterSubscriptionSystem subscriptionSystem = new TwitterSubscriptionSystem();

        CompletableFuture<Void> future1 = subscriptionSystem.followAccount(jack);
        CompletableFuture<Void> future2 = subscriptionSystem.followAccount(jack);
        CompletableFuture<Void> future3 = subscriptionSystem.followAccount(jack);

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(future1, future2, future3);
        allFutures.join();
        subscriptionSystem.shutdown();

        log.info("Total followers for {}: {}", jack.getUsername(), jack.getFollowers());
    }
}