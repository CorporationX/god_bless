package school.faang.bjs2_92967;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    public static void main(String[] args) {
        TwitterAccount account = new TwitterAccount("elonmask", 0);
        TwitterSubscriptionSystems system = new TwitterSubscriptionSystems();

        List<CompletableFuture<Void>> futures = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            futures.add(system.followAccount(account));
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        log.info("Подписчиков: {}", account.getFollowers());
    }
}
