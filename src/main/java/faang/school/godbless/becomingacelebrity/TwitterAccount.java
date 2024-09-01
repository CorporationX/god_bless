package faang.school.godbless.becomingacelebrity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TwitterAccount {
    private String username;
    private long followers;

    public TwitterAccount(String username) {
        this.username = username;
        this.followers = 0;
    }

    public synchronized void addFollower() {
        this.followers++;
    }
}