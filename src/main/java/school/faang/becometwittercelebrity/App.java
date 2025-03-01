package school.faang.becometwittercelebrity;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class App {
    private static final int FOLLOWERS_AMOUNT = 100;

    public static void main(String[] args) {
        TwitterAccount account = new TwitterAccount("john_doe", 0);
        TwitterSubscriptionSystem subscriptionSystem = new TwitterSubscriptionSystem();
        List<CompletableFuture<Void>> tasks = new ArrayList<>();

        for (int i = 0; i < FOLLOWERS_AMOUNT; i++) {
            tasks.add(subscriptionSystem.followAccount(account));
        }

        CompletableFuture.allOf(tasks.toArray(new CompletableFuture[0])).join();

        log.info("Количество подписчиков учетной записи {} = {}",
                account.getUsername(), account.getFollowers());
    }
}
