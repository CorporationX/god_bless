package school.faang.module1.sprint4.twittercelebrity;

import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;

@Data
public class TwitterAccount {
    private final String username;
    private AtomicInteger followers = new AtomicInteger(0);

    public void incrementFollowers() {
        followers.getAndIncrement();
    }
}