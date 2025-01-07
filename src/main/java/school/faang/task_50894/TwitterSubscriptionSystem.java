package school.faang.task_50894;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class TwitterSubscriptionSystem {

    public synchronized void addFollower(TwitterAccount account, TwitterAccount subscriber) {
        if (account.equals(subscriber)) {
            log.warn("Вы не можете подписаться сами на себя");
            return;
        }
        account.setFollowers(account.getFollowers() + 1);
    }

    public CompletableFuture<Void> followAccount(TwitterAccount account, TwitterAccount subscriber) {
        log.info("На вас подписался {}", subscriber.getUsername());
        return CompletableFuture.runAsync(() -> this.addFollower(account, subscriber));
    }
}
