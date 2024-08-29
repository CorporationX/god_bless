package faang.school.godbless.bjs2_24780;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TwitterAccount {
    private String username;
    private int followers;

    public TwitterAccount(String username) {
        this.username = username;
    }

    public void addFollower() {
        followers += 1;
    }
}
