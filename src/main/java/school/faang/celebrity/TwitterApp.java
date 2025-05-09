package school.faang.celebrity;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class TwitterApp {
    public static void main(String[] args) {
        TwitterAccount account = new TwitterAccount("MageOfMorrowind");
        TwitterSubscriptionSystem system = new TwitterSubscriptionSystem();

        List<CompletableFuture<Void>> futures =
                java.util.stream.IntStream.range(0, 10)
                        .mapToObj(i -> system.followAccount(account))
                        .toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        log.info("Total followers for {} - {} ", account.getUsername(), account.getFollowers());
    }
}
