package become_selebrity_in_twitter;

import java.util.concurrent.atomic.AtomicInteger;

class TwitterAccount {
    private final String username;
    private final AtomicInteger followers;

    public TwitterAccount(String username) {
        this.username = username;
        this.followers = new AtomicInteger(0);
    }

    public String getUsername() {
        return username;
    }

    public int getFollowers() {
        return followers.get();
    }

    public void addFollower() {
        followers.incrementAndGet();
    }
}
