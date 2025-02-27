package school.faang.bjs2_62413;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@AllArgsConstructor
public class TwitterAccount {
    private final String userName;

    @Setter(AccessLevel.NONE)
    private final AtomicInteger followers;

    public int incrementFollowers() {
        return followers.incrementAndGet();
    }
}
