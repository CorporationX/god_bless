package school.faang.sprint4.task50782twitter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TwitterAccount {
    private String username;
    private volatile int followers;

    public TwitterAccount(String username) {
        this.username = username;
        this.followers = 0;
    }
}
