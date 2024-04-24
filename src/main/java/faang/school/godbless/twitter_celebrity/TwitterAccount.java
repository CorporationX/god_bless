package faang.school.godbless.twitter_celebrity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TwitterAccount {
    private String username;
    private int followers;

    public synchronized void changeFollowersCount() {
        followers++;
    }
}
