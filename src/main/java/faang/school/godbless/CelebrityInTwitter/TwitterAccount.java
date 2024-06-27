package faang.school.godbless.CelebrityInTwitter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
@ToString
public class TwitterAccount {
    private String username;
    private AtomicInteger followers;

    public TwitterAccount(String username) {
        this.username = username;
        this.followers = new AtomicInteger(0);
    }
}
