package faang.school.godbless.twitterFollowers;

import lombok.Data;

@Data
public class TwitterAccount {
    private final String username;
    private int followers = 0;

    public TwitterAccount(String username) {
        this.username = username;
    }
}
