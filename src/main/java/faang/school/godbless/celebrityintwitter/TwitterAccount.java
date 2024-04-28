package faang.school.godbless.celebrityintwitter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TwitterAccount {

    private final String userName;
    private int followers;

    public TwitterAccount(String userName) {
        this.userName = userName;
        this.followers = 0;
    }

    public void incrementFollowers() {
        this.followers++;
    }
}
