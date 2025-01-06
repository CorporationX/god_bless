package school.faang.sprint4.task_43580;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class TwitterSubscriptionSystem {

    public void addFollower(TwitterAccount account) {
        synchronized (account) {
            account.setNumOfFollowers(account.getNumOfFollowers() + 1);
            log.debug("A new follower has been added to the account {}", account);
        }
    }

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> addFollower(account));
    }
}
