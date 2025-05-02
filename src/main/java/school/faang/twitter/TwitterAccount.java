package school.faang.twitter;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Data
public class TwitterAccount {
    private final String username;
    private final AtomicInteger followers;

    public TwitterAccount(String username) {
        this.username = username;
        followers = new AtomicInteger(0);
    }

    public void addOneFollower() {
        followers.incrementAndGet();
    }
}
