package school.faang.task_50669;

import lombok.Getter;
import school.faang.exception.CheckException;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class TwitterAccount {
    private final String username;
    private final AtomicInteger followers;

    public TwitterAccount(String username, int followers) {
        if (username == null || username.isEmpty()) {
            throw new CheckException("username");
        }
        this.username = username;
        this.followers = new AtomicInteger(followers);
    }

    public void addFollower() {
        this.followers.incrementAndGet();
    }
}
