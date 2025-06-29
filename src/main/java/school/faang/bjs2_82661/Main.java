package school.faang.bjs2_82661;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    private static final int FOLLOWERS_COUNT = 1000;

    public static void main(String[] args) {
        TwitterAccount account = new TwitterAccount("Twitter");
        TwitterSubscriptionSystem system = new TwitterSubscriptionSystem();

        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (int i = 0; i < FOLLOWERS_COUNT; i++) {
            futures.add(system.followAccount(account));
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        log.info("Количество подписчиков: {}", account.getFollowers());
    }
}
