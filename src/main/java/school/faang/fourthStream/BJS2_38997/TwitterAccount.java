package school.faang.fourthStream.BJS2_38997;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class TwitterAccount {
    private final AtomicInteger followers;
    @Setter
    private String username;

    public TwitterAccount(String username) {
        this.username = username;
        this.followers = new AtomicInteger(0);
    }

    public void addFollower() {
        followers.incrementAndGet();
    }

    public void removeFollower() {
        followers.decrementAndGet();
    }
}
