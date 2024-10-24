package school.faang.BJS2_39022_TwitterCelebrity;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

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
    }
}
