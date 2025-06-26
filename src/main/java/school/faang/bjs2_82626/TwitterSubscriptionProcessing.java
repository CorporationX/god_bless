package school.faang.bjs2_82626;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class TwitterSubscriptionProcessing {
    private static final long FOLLOWERS_COUNT = 200_000;

    public static void main(String[] args) {
        TwitterSubscriptionSystem system = new TwitterSubscriptionSystem();
        TwitterAccount account = new TwitterAccount("Me");

        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (int i = 0; i < FOLLOWERS_COUNT; i++) {
            futures.add(system.followAccount(account));
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        log.info("Количество подписчиков {}: {}", account.getUsername(), account.getFollowers().get());
    }
}
