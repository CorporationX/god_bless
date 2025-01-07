package school.faang.task_51666;


import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Getter
@ToString
public class TwitterAccount {
    private String userName;
    private final AtomicInteger followers;

    public TwitterAccount(String userName) {
        if (userName.isEmpty()) {
            throw new IllegalArgumentException("UserName cannot be empty");
        }
        this.userName = userName;
        this.followers = new AtomicInteger(0);
    }

    public void addFollower() {
        followers.incrementAndGet();
    }
}
