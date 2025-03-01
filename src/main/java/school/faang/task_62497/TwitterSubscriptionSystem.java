package school.faang.task_62497;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class TwitterSubscriptionSystem {

    public synchronized void addFollower(TwitterAccount account) {
        account.getFollowers().incrementAndGet();
    }

    public CompletableFuture<Void> followAccount(TwitterAccount account) {

        return CompletableFuture
                .runAsync(() -> {
                    this.addFollower(account);
                })
                .thenRun(() -> log.info("колличество подписчиков у "
                        + account.getUsername() + " равно : " + account.getFollowers()))
                .exceptionally(ex -> {
                    log.error("Ошибка при добавлении подписчика к аккаунту " + account.getUsername(), ex);
                    return null;
                });
    }
}
