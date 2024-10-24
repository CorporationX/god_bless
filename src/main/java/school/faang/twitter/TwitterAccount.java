package school.faang.twitter;

import lombok.Getter;

import java.util.Objects;

@Getter
public class TwitterAccount {

    private String username;
    private int followers;

    public TwitterAccount(String username) {
        Objects.requireNonNull(username, "Username cannot be null");
        this.username = username;
    }

    public void setUsername(String username) {
        Objects.requireNonNull(username, "Username cannot be null");
        this.username = username;
    }

    public void addFollower() {
        this.followers++;
    }
}
