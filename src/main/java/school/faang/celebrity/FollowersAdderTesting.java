package school.faang.celebrity;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class FollowersAdderTesting {
    public static void main(String[] args) {
        TwitterSubscriptionSystem subscriptionSystem = new TwitterSubscriptionSystem();
        TwitterAccount account = new TwitterAccount("Sam", new AtomicInteger(3));

        log.info("Стартовое число подписчиков аккаунта {} равно {}.",
                account.getUsername(), account.getFollowers());

        CompletableFuture<Void>[] futures = new CompletableFuture[100];

        for (int i = 0; i < 100; i++) {
            futures[i] = subscriptionSystem.followAccount(account);
        }

        CompletableFuture.allOf(futures).join();
        subscriptionSystem.closeExecutor();

        log.info("Обновленное число подписчиков аккаунта {} равно {}.",
                account.getUsername(), account.getFollowers());
    }
}
