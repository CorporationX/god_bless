package school.faang.celebritytwitter;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@AllArgsConstructor
public class TwitterAccount {
    private String username;
    private final AtomicInteger followers;

    public void addFollowersToUser() {
        followers.incrementAndGet();
    }
}
