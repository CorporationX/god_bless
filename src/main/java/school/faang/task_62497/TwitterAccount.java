package school.faang.task_62497;


import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;

@Data
public class TwitterAccount {
    private final String username;
    private final AtomicInteger followers;

    public TwitterAccount(String username, int followers) {
        this.username = username;
        this.followers = new AtomicInteger(followers);
    }
}
