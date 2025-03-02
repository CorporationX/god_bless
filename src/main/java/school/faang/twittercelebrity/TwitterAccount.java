package school.faang.twittercelebrity;

import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;

@Data
public class TwitterAccount {
    private final String username;
    private final AtomicInteger followers = new AtomicInteger(0);

    public TwitterAccount(String username) {
        this.username = username;
    }

    public void addFollower() {
        followers.incrementAndGet();
    }
}
