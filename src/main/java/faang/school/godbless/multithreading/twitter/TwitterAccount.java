package faang.school.godbless.multithreading.twitter;

import java.util.concurrent.atomic.AtomicInteger;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TwitterAccount {
    private int id;
    private AtomicInteger followers;

    public TwitterAccount(int id) {
        this.id = id;
        followers = new AtomicInteger(0);
    }
}
