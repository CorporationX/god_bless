package school.faang.celebrityintwitter;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@AllArgsConstructor
public class TwitterAccount {
    private final String username;
    private AtomicInteger followers;

    public void incrementFollowers() {
        this.followers.getAndIncrement();
    }


}
