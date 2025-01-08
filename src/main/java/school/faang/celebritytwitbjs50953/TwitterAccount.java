package school.faang.celebritytwitbjs50953;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TwitterAccount {
    private String username;
    private int followers;

    public TwitterAccount(String username) {
        this.username = username;
        this.followers = 0;
    }
}
