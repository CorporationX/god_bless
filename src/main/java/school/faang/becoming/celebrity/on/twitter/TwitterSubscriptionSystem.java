package school.faang.becoming.celebrity.on.twitter;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class TwitterSubscriptionSystem {
    private final Object lock = new Object();

    public void addFollower(TwitterAccount account) {
        synchronized (lock) {
            int newCountFollowers = account.getFollowers() + 1;
            account.setFollowers(newCountFollowers);
        }
    }

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> addFollower(account));
    }

    public CompletableFuture<Void> addMultipleFollowers(TwitterAccount account, int followersCount) {
        List<CompletableFuture<Void>> futures = new ArrayList<>();

        for (int i = 0; i < followersCount; i++) {
            futures.add(followAccount(account));
        }

        return CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
    }

    public static void main(String[] args) {
        TwitterSubscriptionSystem system = new TwitterSubscriptionSystem();

        TwitterAccount account1 = new TwitterAccount("Java Expert", 100);
        TwitterAccount account2 = new TwitterAccount("Spring Guru", 200);
        TwitterAccount account3 = new TwitterAccount("Hibernate Master", 150);

        CompletableFuture<Void> future1 = system.addMultipleFollowers(account1, 500);
        CompletableFuture<Void> future2 = system.addMultipleFollowers(account2, 300);
        CompletableFuture<Void> future3 = system.addMultipleFollowers(account3, 400);

        // Ожидаем завершения всех задач для всех аккаунтов
        CompletableFuture.allOf(future1, future2, future3).join();

        log.info("Аккаунт '{}': {} подписчиков", account1.getUsername(), account1.getFollowers());
        log.info("Аккаунт '{}': {} подписчиков", account2.getUsername(), account2.getFollowers());
        log.info("Аккаунт '{}': {} подписчиков", account3.getUsername(), account3.getFollowers());
    }
}
