package faang.school.godbless.become_a_celebrity_on_twitter;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class TwitterAccount {
    private String userName;
    private AtomicInteger followers;

    public TwitterAccount(String userName) {
        this.userName = userName;
        this.followers = new AtomicInteger(0);
    }
}
