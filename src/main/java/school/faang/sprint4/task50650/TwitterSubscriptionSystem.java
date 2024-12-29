package school.faang.sprint4.task50650;

import lombok.extern.slf4j.Slf4j;
import school.faang.sprint4.task50650.model.TwitterAccount;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@Slf4j
public class TwitterSubscriptionSystem {
    private static final int SLEEP_MSEC = 2000;

    public static CompletableFuture<Void> followAccount(ExecutorService executor, TwitterAccount account) {
        return CompletableFuture.runAsync(() -> addFollower(account), executor);
    }

    private static void addFollower(TwitterAccount account) {
        try {
            Thread.sleep(SLEEP_MSEC);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        int followers = account.incrementFollowersCount();
        log.info("У пользователя {} новый подписчик! Теперь всего подписчиков {}", account.getUsername(), followers);
    }
}
