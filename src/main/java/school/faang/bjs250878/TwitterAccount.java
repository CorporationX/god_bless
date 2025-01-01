package school.faang.bjs250878;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class TwitterAccount {

    private final String username;
    @Setter
    private int followers;

    public TwitterAccount(String username) {
        if (username == null || username.trim().isEmpty()) {
            log.error("Username cannot be null or empty");
            throw new IllegalArgumentException("Username cannot be null or empty");
        }

        this.username = username;
        this.followers = 0;

    }
}
