package faang.school.godbless.celebrity_twitter;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class TwitterAccount {
    private String name;
    private AtomicInteger followers;

    public TwitterAccount(String name) {
        this.name = name;
        followers = new AtomicInteger(0);
    }
}
