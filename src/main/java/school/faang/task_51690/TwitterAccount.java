package school.faang.task_51690;

import lombok.Getter;

@Getter
public class TwitterAccount {
    private String username;
    private int followers;

    public TwitterAccount(String username) {
        this.username = username;
        this.followers = 0;
    }

    public synchronized void addFollower() {
        followers++;
    }
}
