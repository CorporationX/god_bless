package school.faang.task_50894;

import lombok.Data;

@Data
public class TwitterAccount {
    private String username;
    private int followers;

    public TwitterAccount(String username, int followers) {
        this.username = username;
        this.followers = followers;
    }
}
