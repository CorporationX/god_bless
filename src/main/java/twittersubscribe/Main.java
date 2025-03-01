package twittersubscribe;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

@Slf4j
public class Main {

    public static void main(String[] args) throws InterruptedException {
        TwitterAccount account = new TwitterAccount("User Evgeny");
        TwitterSubscriptionSystem system = new TwitterSubscriptionSystem();

        CompletableFuture<?>[] futures = IntStream.rangeClosed(1, 1_000)
                .mapToObj(followerNumber -> system.followAccount(account, followerNumber))
                .toArray(CompletableFuture[]::new);

        CompletableFuture.allOf(futures).join();

        log.info("Total followers: {}", account.getFollowers().get());

        system.shutdown();
    }
}

