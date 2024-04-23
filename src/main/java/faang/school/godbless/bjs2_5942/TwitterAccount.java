package faang.school.godbless.bjs2_5942;

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
}
