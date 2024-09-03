package faang.school.godbless.BJS224874;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class TwitterAccount {
    private String username;
    private AtomicInteger followers;

    public TwitterAccount(String username) {
        this.username = username;
        this.followers = new AtomicInteger(0);
    }

    public void addFollower() {
        followers.incrementAndGet();
    }
}
