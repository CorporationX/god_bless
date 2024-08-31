package faang.school.godbless.BJS2_24846;

import lombok.Getter;

@Getter
public class TwitterAccount {
    private final String username;
    private int followers;

    public TwitterAccount(String username) {
        this.username = username;
    }

    public synchronized int getFollowers() {
        return followers;
    }

    public synchronized void addFollower() {
        followers++;
    }
}
