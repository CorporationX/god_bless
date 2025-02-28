package school.faang.twitter_celebrity;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class TwitterSubscriptionSystem {
    private final int addingTime = 1000;

    public synchronized void addFollower(TwitterAccount account) {
        account.setFollowers(account.getFollowers() + 1);
        log.info("Подписчик добавлен для {}. Количество подписчиков: {}", account.getName(), account.getFollowers());
    }

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(addingTime);
                addFollower(account);
            } catch (InterruptedException e) {
                log.warn("Ошибка в работе потока");
                Thread.currentThread().interrupt();
                throw new RuntimeException();
            }
        });

    }
}
