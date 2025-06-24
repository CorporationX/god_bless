package school.faang.celebrity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor
@Getter
@Setter
public class TwitterAccount {
    private String username;
    private AtomicInteger followers;

    public void followersIncrement() {
        followers.incrementAndGet();
    }
}
