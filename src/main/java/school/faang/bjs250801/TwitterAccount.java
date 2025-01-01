package school.faang.bjs250801;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Getter
public class TwitterAccount {
    private final String username;
    private final AtomicInteger followers = new AtomicInteger(0);

    public TwitterAccount(String username) {
        this.username = username;
    }

    public void addFolower() {
        followers.incrementAndGet();
    }
}