package faang.school.godbless.celebrityTwitter;

import lombok.Data;
import java.util.concurrent.atomic.AtomicInteger;

@Data
public class TwitterAccount {
    private String username;
    private AtomicInteger followers;

    public TwitterAccount(String username) {
        this.username = username;
        this.followers = new AtomicInteger(0);
    }

}
