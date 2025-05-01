package school.faang.twittercelebrity;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class TwitterAccount {
    private final String userName;
    private final AtomicInteger followers;

    public TwitterAccount(String userName, int followers) {
        this.userName = userName;
        this.followers = new AtomicInteger(followers);
    }

    public void incrementFollowers() {
        followers.incrementAndGet();
    }
}
