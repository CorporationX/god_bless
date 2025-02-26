package school.faang.twittercelebrity;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
public class TwitterSubscriptionSystem {
    private void addFollower(TwitterAccount account) {
        account.getFollowers().incrementAndGet();
        log.info("Account {} has a new follower.", account.getUsername());
    }

    public void followAccount(TwitterAccount account) {
        Objects.requireNonNull(account, "Invalid account value");
        addFollower(account);
    }
}
