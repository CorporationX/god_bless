package school.faang.bjs2_92990;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicLong;

@Getter
@Setter
public class TwitterAccount {
    private String username;
    private AtomicLong followers = new AtomicLong();

    public TwitterAccount(String username) {
        this.username = username;
    }
}
