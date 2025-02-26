package school.faang.becomingatwittercelebrity;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {

    private static final int NUMBER_OF_SUBSCRIPTIONS = 10;

    public static void main(String[] args) {
        TwitterAccount account = new TwitterAccount("Hayotbek", 0);
        TwitterSubscriptionSystem system = new TwitterSubscriptionSystem();

        List<CompletableFuture<Void>> futures = new ArrayList<>();

        for (int i = 0; i < NUMBER_OF_SUBSCRIPTIONS; i++) {
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> system.followAccount(account));
            futures.add(future);
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        log.info("Пользователь {} набрал {} подписчиков!", account.getUserName(), account.getFollowers());
    }
}
