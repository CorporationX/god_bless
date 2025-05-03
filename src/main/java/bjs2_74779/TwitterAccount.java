package bjs2_74779;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
public class TwitterAccount {
    private String username;
    private AtomicInteger followers;

    public TwitterAccount(String username, int followers) {
        this.username = username;
        this.followers = new AtomicInteger(followers);
    }
}
