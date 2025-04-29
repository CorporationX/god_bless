package school.faang.async.twitter;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

@Slf4j
public class Main {

    private static final int FOLLOWERS_TO_GENERATE = 100;

    public static void main(String[] args) {
        TwitterAccount newAccount = new TwitterAccount(UsernameGenerator.generateUserName(), new AtomicInteger(1000));

        TwitterSubscriptionSystem system = new TwitterSubscriptionSystem();

        CompletableFuture<Void> future = CompletableFuture.allOf(generateFollowers(system, newAccount));

        future.join();

        log.info("Total followers of {}: {}", newAccount.getUserName(), newAccount.getFollowers());
    }

    private static CompletableFuture[] generateFollowers(TwitterSubscriptionSystem system, TwitterAccount account) {
        return IntStream.range(0, FOLLOWERS_TO_GENERATE)
                .mapToObj((follower) -> CompletableFuture.runAsync(() ->
                        system.followAccount(account)))
                .toArray(CompletableFuture[]::new);
    }
}
