package faang.school.godbless.BecomingACelebrityOnTwitter;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@Data
public class TwitterAccount {
    private String username;
    private AtomicLong followers = new AtomicLong(0);

    public void followAccount(TwitterAccount twitterAccount) {
        TwitterSubscriptionSystem.addFollower(twitterAccount);
        log.info(username + " subscribed to " + twitterAccount.getUsername());
    }

    public TwitterAccount(String username) {
        this.username = username;
    }
}