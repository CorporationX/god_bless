package faang.school.godbless.BJS2_24693;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor
public class TwitterAccount {
    @Getter
    private final String name;
    private final AtomicInteger followers = new AtomicInteger(0);

    public void incrementFollowers() {
        followers.getAndIncrement();
    }

    public int getFollowersCount() {
        return followers.get();
    }
}
