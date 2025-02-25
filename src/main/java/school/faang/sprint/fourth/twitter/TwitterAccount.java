package school.faang.sprint.fourth.twitter;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class TwitterAccount {
    @NonNull
    private String username;
    private int followers = 0;

    public TwitterAccount(@NonNull String username) {
        if (username.isBlank()) {
            throw new IllegalArgumentException("Username cannot be blank");
        }
        this.username = username;
    }
}
