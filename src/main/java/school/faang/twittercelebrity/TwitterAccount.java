package school.faang.twittercelebrity;

import lombok.Data;

@Data
public class TwitterAccount {
    private final String username;
    private int followers;

    public TwitterAccount(String username) {
        this.username = username;
    }

    public synchronized void addFollower() {
        this.followers++;
    }
}
