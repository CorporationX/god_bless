package school.faang.BJS2_64794;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor
@Getter
public class TwitterAccount {
    private final String username;
    private AtomicInteger followers;

    public int getFollowers() {
        return followers.get();
    }

    public void incrementFollowers() {
        followers.incrementAndGet();
    }
}
