package Sprint_4_1_Task11;

import lombok.Data;
@Data
public class TwitterAccount {
    private String username;
    private int followers;

    public TwitterAccount(String username) {
        this.username = username;
    }
}
