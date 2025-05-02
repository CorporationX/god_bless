package school.faang.twitter;

import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;

@Data
public class TwitterAccount {
    private final String username;
    private final AtomicInteger followers;

    public TwitterAccount(String username, int followers) {
        this.username = username;
        this.followers = new AtomicInteger(followers);
    }

    public void addFollower() {
        followers.incrementAndGet();
    }
}
