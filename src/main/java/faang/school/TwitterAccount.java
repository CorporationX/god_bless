package faang.school;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.concurrent.atomic.AtomicInteger;

@Data
@RequiredArgsConstructor
public class TwitterAccount {
    @NonNull
    private String username;
    private AtomicInteger followers = new AtomicInteger(0);
    public void followersInc(){
        followers.incrementAndGet();
    }
}
