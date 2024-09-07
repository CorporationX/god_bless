package faang.school.godbless.BJS224874;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class TwitterAccount {
    private String username;
    private AtomicInteger followersCount;

    public TwitterAccount(String username) {
        this.username = username;
        this.followersCount = new AtomicInteger(0);
    }

    public void incrementFollowersCount() {
        followersCount.incrementAndGet();
    }
}
