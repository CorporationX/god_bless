package school.faang.twitter;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

@Slf4j
public class Main {

    public static void main(String[] args) {
        TwitterAccount account = new TwitterAccount("elon");
        try (TwitterSubscriptionSystem subscriptionSystem = new TwitterSubscriptionSystem()) {
            CompletableFuture.allOf(
                    IntStream.range(0, 5)
                            .mapToObj(i -> subscriptionSystem.followAccount(account))
                            .toArray(CompletableFuture[]::new)
            ).join();
            log.info("Total account followers: {}", account.getFollowers());
        }
    }
}
