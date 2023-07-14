package faang.school.godbless.kxnvg.twitter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TwitterAccount {

    private String userName;
    private int followers;

    public TwitterAccount(String userName) {
        this.userName = userName;
        followers = 0;
    }
}
