package school.faang.BJS239060;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor
@Data
public class TwitterAccount {
    private final String username;
    private final AtomicInteger followers;

    public TwitterAccount(String username, int initialFollowers) {
        this.username = username;
        this.followers = new AtomicInteger(initialFollowers);
    }
}
