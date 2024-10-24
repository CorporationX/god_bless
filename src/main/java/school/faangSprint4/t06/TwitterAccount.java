package school.faangSprint4.t06;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TwitterAccount {
    private String username;
    private int followers;

    public TwitterAccount(String username) {
        this.username = username;
        this.followers = 0;
    }

    @Override
    public String toString() {
        return "TwitterAccount{" +
                "username='" + username + '\'' +
                ", followers=" + followers +
                '}';
    }
}