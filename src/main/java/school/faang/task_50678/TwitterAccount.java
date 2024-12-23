package school.faang.task_50678;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.concurrent.atomic.AtomicInteger;

@RequiredArgsConstructor
public class TwitterAccount {
    @Getter
    private final String username;
    private AtomicInteger followers = new AtomicInteger(0);

    public int getFollowers() {
        return followers.get();
    }

    public void addFollower() {
        followers.addAndGet(1);
    }
}
