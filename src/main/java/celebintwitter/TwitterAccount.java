package celebintwitter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor
@Getter
@Setter
public class TwitterAccount {
    private String username;
    private AtomicInteger followersCount;

    public TwitterAccount(String username, int initialFollowersCount) {
        this.username = username;
        this.followersCount = new AtomicInteger(initialFollowersCount);
    }
}
