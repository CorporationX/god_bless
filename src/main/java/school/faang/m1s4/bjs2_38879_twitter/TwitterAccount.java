package school.faang.m1s4.bjs2_38879_twitter;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@RequiredArgsConstructor
@Setter
public class TwitterAccount {
    @Getter
    private final String username;
    private AtomicInteger followers = new AtomicInteger(0);

    public int incrementFollowers() {
        return followers.incrementAndGet();
    }

    public int getFollowers() {
        return followers.get();
    }
}
