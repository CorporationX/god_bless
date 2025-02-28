package school.faang.task_62497;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class TwitterSubscriptionSystem {

    public synchronized void addFollower(TwitterAccount account) {
        CompletableFuture.runAsync(() -> {
            account.setFollowers(account.getFollowers() + 1);
        });
    }

    public void followAccount(TwitterAccount account) {
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            this.addFollower(account);
        });
        completableFuture
                .thenRun(() -> log.info("колличество подписчиков у "
                        + account.getUsername() + " равно : " + account.getFollowers()))
                .join();
    }
}
