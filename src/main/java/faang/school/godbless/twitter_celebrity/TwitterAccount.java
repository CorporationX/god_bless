package faang.school.godbless.twitter_celebrity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor
@Getter
public class TwitterAccount {
    private String username;
    private AtomicInteger followers;

    public void setFollowers(){
        followers.addAndGet(1);
    }
}
