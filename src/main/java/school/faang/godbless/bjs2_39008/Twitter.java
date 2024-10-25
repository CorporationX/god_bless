package school.faang.godbless.bjs2_39008;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

@Slf4j
public class Twitter {
    public static void main(String[] args) {
        TwitterAccount celebrity = new TwitterAccount("Celebrity", 0);
        TwitterSubscriptionSystem subscriptionSystem = new TwitterSubscriptionSystem();
        List<CompletableFuture<Void>> futures = IntStream.rangeClosed(1, 100)
                .mapToObj(i -> subscriptionSystem.followAccount(celebrity)).toList();
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        log.info("Celebrity has {} followers", celebrity.getFollowers());
        subscriptionSystem.shutdown();
    }
}
