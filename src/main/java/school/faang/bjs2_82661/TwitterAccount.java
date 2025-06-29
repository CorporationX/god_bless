package school.faang.bjs2_82661;

import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;

@Data
public class TwitterAccount {
    private final String username;
    private AtomicInteger followers;

    public TwitterAccount(String username) {
        this.username = username;
        this.followers = new AtomicInteger(0);
    }
}
