package school.faang.bjs2_75748;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@Setter
@Getter
public class TwitterAccount {
    private String userName;
    private AtomicInteger followers;

    public TwitterAccount(String userName) {
        this.userName = userName;
        this.followers = new AtomicInteger(0);
    }
}
