package school.faang.bjs2_92949;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor
@Setter
@Getter
public class TwitterAccount {
    private String username;
    private AtomicInteger followers;

    public void addFollower() {
        followers.incrementAndGet();
    }

    public int getFollowersCount() {
        return followers.get();
    }
}
