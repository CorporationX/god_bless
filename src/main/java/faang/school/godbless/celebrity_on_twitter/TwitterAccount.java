package faang.school.godbless.celebrity_on_twitter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TwitterAccount {
    private final String username;
    private int followers;

    public TwitterAccount(String username) {
        this.username = username;
        this.followers = 0;
    }
}
