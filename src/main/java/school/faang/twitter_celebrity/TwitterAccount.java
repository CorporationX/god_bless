package school.faang.twitter_celebrity;

import lombok.Getter;

@Getter
public class TwitterAccount {
    private final String username;
    private int followers;

    public TwitterAccount(String username) {
        this.username = username;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }
}
