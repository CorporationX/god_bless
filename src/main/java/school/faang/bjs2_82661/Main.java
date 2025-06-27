package school.faang.bjs2_82661;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    public static void main(String[] args) {
        TwitterAccount account = new TwitterAccount("Twitter");
        TwitterSubscriptionSystem system = new TwitterSubscriptionSystem();
        int followersCount = 1000;

        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (int i = 0; i < followersCount; i++) {
            futures.add(system.followAccount(account));
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        log.info("Количество подписчиков: {}", account.getFollowers());
    }
}
