package school.faang.bjs2_82661;

import lombok.Data;

@Data
public class TwitterAccount {
    private final String username;
    private int followers;

    public TwitterAccount(String username) {
        this.username = username;
        this.followers = 0;
    }
}
