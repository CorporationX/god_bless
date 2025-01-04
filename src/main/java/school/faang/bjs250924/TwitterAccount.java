package school.faang.bjs250924;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.concurrent.atomic.AtomicInteger;

@RequiredArgsConstructor
@Getter
public class TwitterAccount {
    private final String username;
    private final AtomicInteger followers = new AtomicInteger(0);

    public void updateFollowersCount(int delta) {
        followers.addAndGet(delta);
    }
}
