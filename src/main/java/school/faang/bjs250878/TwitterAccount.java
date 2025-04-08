package school.faang.bjs250878;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Getter
public class TwitterAccount {

    private final String username;
    private final AtomicInteger followers;

    public TwitterAccount(String username) {
        if (username == null || username.trim().isEmpty()) {
            log.error("Username cannot be null or empty");
            throw new IllegalArgumentException("Username cannot be null or empty");
        }

        this.username = username;
        this.followers = new AtomicInteger(0);
    }

    public void addFollower() {
        followers.incrementAndGet();
    }

    public int getFollowers() {
        return followers.get();
    }
}