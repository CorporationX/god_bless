package school.faang.twitter;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class TwitterSubscriptionSystem {
    public static synchronized void addFollower(TwitterAccount account) {
        account.setFollowers(account.getFollowers() + 1);
        log.info("Added follower to account {} new followers count {}", account, account.getFollowers());

    }

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> TwitterSubscriptionSystem.addFollower(account));
    }
}
