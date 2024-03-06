package faang.school.godbless.twitter;

import java.util.concurrent.atomic.AtomicInteger;

public class TwitterAccount {
    private final String userName;
    private AtomicInteger followers;

    public String getUserName() {
        return userName;
    }

    public TwitterAccount(String userName) {
        this.userName = userName;
        followers = new AtomicInteger(0);
    }

    public AtomicInteger getFollowers() {
        return followers;
    }
}
