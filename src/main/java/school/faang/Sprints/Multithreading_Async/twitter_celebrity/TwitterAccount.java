package school.faang.Sprints.Multithreading_Async.twitter_celebrity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
public class TwitterAccount {
    private String username;
    private AtomicInteger followers = new AtomicInteger();

    public TwitterAccount(String username){
        this.username = username;
    }

}
