package school.faang.Twitter;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Data
public class TwitterAccount {
    private String username;
    private final AtomicInteger followers = new AtomicInteger(0);
    private final List<TwitterAccount> following = new ArrayList<>();

    public TwitterAccount(String username) {
        this.username = username;
    }

    public synchronized void addFollower(TwitterAccount follower) {
        if (this.equals(follower)) {
            throw new IllegalArgumentException("Cannot subscribe...");
        }
        followers.incrementAndGet();
        following.add(follower);
        log.info("{} followed {}: followers: {}", follower.getUsername(), username, getFollowers());
    }

    public synchronized void removeFollower(TwitterAccount follower) {
        followers.decrementAndGet();
        following.remove(follower);
        log.info("{} unsubscribed to {}: followers: {}", follower.getUsername(), username, getFollowers());
    }

    public int getFollowers() {
        return followers.get();
    }

    @Override
    public String toString() {
        return "Username='" + username + '\'' +
                ", followers=" + followers +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TwitterAccount that = (TwitterAccount) o;
        return getUsername().equals(that.getUsername());
    }

    @Override
    public int hashCode() {
        return getUsername().hashCode();
    }
}
