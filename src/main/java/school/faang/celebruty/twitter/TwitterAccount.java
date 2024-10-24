package school.faang.celebruty.twitter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
@AllArgsConstructor
public class TwitterAccount {
    private String username;
    private final AtomicInteger followers = new AtomicInteger(0);

    public void incrementFollowers() {
        followers.incrementAndGet();
    }

    public int getFollowersCount() {
        return followers.get();
    }
}
