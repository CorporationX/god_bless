package school.faang.s_4_1_become_twitter_celebrity;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class TwitterAccount {
    private String username;
    private AtomicInteger followers;

    public TwitterAccount(String username) {
        String name = TwitterUsernames.addUsername(username);
        this.username = name;
        this.followers = new AtomicInteger(0);
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFollowers(int followers) {
        this.followers = new AtomicInteger(followers);
    }

    public String getUsername() {
        return username;
    }

    public int getFollowers() {
        return followers.get();
    }

    public void incrementFollowers() {
        followers.incrementAndGet();
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return  true;
        if (o == null || getClass() != o.getClass()) return false;
        TwitterAccount that = (TwitterAccount) o;
        return Objects.equals(username, that.username);
    }
}
