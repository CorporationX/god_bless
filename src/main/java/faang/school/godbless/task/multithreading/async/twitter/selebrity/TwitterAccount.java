package faang.school.godbless.task.multithreading.async.twitter.selebrity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TwitterAccount {
    private final String username;
    private long followers = 0;

    public void addFollower() {
        followers++;
    }
}
