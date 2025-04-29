package school.faang.bjs2_74752;

import lombok.Getter;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@ToString
public class TwitterAccount {
    private final String username;
    private final AtomicInteger followers;

    public TwitterAccount(String username, int followers) {
        this.username = username;
        this.followers = new AtomicInteger(followers);
    }
}
