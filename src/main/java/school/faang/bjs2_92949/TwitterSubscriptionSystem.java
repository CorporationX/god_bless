package school.faang.bjs2_92949;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class TwitterSubscriptionSystem {

    private void addFollower(TwitterAccount account) {
        if (account == null) {
            log.error("account cannot be null");
            return;
        }
        synchronized (account) {
            account.setFollowers(account.getFollowers() + 1);
            log.info("followers added");
        }
    }

    public void followAccount(TwitterAccount account) {
        CompletableFuture.runAsync(() -> {
            addFollower(account);
        }).thenRun(() -> {
            System.out.printf("Account: %s, Followers: %s%n", account.getUsername(), account.getFollowers());
        });
    }
}
