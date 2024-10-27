package faang.school.godbless.mt.twitter;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

public class TwitterAccount {
    @Getter
    private String name;
    private final AtomicInteger followers;

    public TwitterAccount(String name) {
        this.name = name;
        followers = new AtomicInteger(0);
    }

    public int addFollower() {
        return followers.incrementAndGet();
    }

    public int getFollowers() {
        return followers.get();
    }
}
