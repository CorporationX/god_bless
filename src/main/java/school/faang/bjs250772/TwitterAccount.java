package school.faang.bjs250772;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
public class TwitterAccount {

    private String username;
    private AtomicInteger followers = new AtomicInteger(0);

    public TwitterAccount(String username) {
        this.username = username;
    }

    public void addFollower() {
        followers.addAndGet(1);
    }

}
