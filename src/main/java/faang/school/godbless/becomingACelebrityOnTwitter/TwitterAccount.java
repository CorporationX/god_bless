package faang.school.godbless.becomingACelebrityOnTwitter;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class TwitterAccount {
    private String username;
    private AtomicInteger followers = new AtomicInteger(0);

    public TwitterAccount(String username, int followers) {
        this.username = username;
        this.followers = new AtomicInteger(followers);
    }
}
