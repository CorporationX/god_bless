package faang.school.godbless.BJS2_24846;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TwitterAccount {
    private final String username;
    private int followers;

    public synchronized int getFollowers() {
        return followers;
    }

    public synchronized void addFollower() {
        followers++;
    }
}
