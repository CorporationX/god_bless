package school.faang.multithreading.asynchronism.celebrity.on.twitter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TwitterAccount {
    private String username;
    private volatile int followers = 0;

    public TwitterAccount(String username) {
        this.username = username;
    }
}
