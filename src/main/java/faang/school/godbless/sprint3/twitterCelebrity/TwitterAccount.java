package faang.school.godbless.sprint3.twitterCelebrity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
public class TwitterAccount {

    private String userName;
    private AtomicInteger followers;

    private Object lock = new Object();

    public TwitterAccount(String userName, AtomicInteger followers) {
        this.userName = userName;
        this.followers = followers;
    }

    public void addFollower() {
        followers.incrementAndGet();
    }



}
