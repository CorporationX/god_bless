package school.faang.task_50821;

import lombok.Data;

@Data
public class TwitterAccount {
    private String username;
    private int followers;

    public TwitterAccount(String username) {
        this.username = username;
        this.followers = 0;
    }
}