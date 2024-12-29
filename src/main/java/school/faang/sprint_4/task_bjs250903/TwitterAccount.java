package school.faang.sprint_4.task_bjs250903;

import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Getter
public class TwitterAccount {
    private final String username;
    private final AtomicInteger followers = new AtomicInteger(0);

    public TwitterAccount(@NonNull String username) {
        this.username = username;
        log.info("Created Account {} followers {}", username, followers.get());
    }

    public void addFollower() {
        followers.incrementAndGet();
    }
}
