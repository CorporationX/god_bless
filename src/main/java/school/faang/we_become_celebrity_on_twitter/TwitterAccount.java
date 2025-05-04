package school.faang.we_become_celebrity_on_twitter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TwitterAccount {
    private final String username;
    private int followers;

    public TwitterAccount(String username, int followers) {
        this.username = username;
        this.followers = followers;
    }
}
