package faang.school.godbless.becomingACelebrityOnTwitter;

import java.util.concurrent.atomic.AtomicInteger;

public class TwitterAccount {
    private String username;
    private AtomicInteger followers = new AtomicInteger(0);

    public TwitterAccount(String username, int followers) {
        this.username = username;
        this.followers = new AtomicInteger(followers);
    }

    public synchronized int getFollowers() {
        return followers.get();
    }

    public synchronized void setFollowers(int follower) {
        followers.set(follower);
    }
}
