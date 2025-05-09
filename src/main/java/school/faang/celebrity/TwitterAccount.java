package school.faang.celebrity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TwitterAccount {
    private final String username;
    private int followers;

    public TwitterAccount(String username) {
        this.username = username;
        this.followers = 0;
    }
}
