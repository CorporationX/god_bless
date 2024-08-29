package celebrity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TwitterAccount {
    private final String username;
    private int followers = 0;

    public synchronized void addFollower() {
        followers++;
    }
}
