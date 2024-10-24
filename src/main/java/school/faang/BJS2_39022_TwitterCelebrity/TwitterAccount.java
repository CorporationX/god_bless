package school.faang.BJS2_39022_TwitterCelebrity;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Getter
public class TwitterAccount {
    private final String username;
    private final AtomicInteger followers;

    public TwitterAccount(String username) {
        this.username = username;
        followers = new AtomicInteger();
    }

    public void addFollower() {
        followers.incrementAndGet();
        log.info("Added new follower to {}'s account", username);
    }
}
