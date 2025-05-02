package school.faang.bjs2_74731;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Data
@Slf4j
@AllArgsConstructor
public class TwitterAccount {

    private static final int THREAD_TIMEOUT_SEC = 3;

    private final String username;
    private AtomicInteger followers;

    public void newFollower() {
        try {
            TimeUnit.SECONDS.sleep(THREAD_TIMEOUT_SEC);
            followers.incrementAndGet();
            log.info("Added new follower to {}", username);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
