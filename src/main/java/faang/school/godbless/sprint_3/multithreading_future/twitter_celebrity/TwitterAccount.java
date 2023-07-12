package faang.school.godbless.sprint_3.multithreading_future.twitter_celebrity;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
public class TwitterAccount {
    private String username;
    private AtomicInteger followers;

    public TwitterAccount(String username) {
        this.username = username;
        this.followers = new AtomicInteger(0);
    }
}