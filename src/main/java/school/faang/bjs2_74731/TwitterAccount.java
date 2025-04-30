package school.faang.bjs2_74731;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Data
@Slf4j
public class TwitterAccount {

    private static final int THREAD_TIMEOUT_SEC = 3;

    private final String username;
    private int followers;

    public TwitterAccount(String username, int followers) {
        this.username = username;
        this.followers = followers;
    }

    public synchronized void newFollower() {
        try {
            TimeUnit.SECONDS.sleep(THREAD_TIMEOUT_SEC);
            log.info("Added new follower to {}", username);
            followers++;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
