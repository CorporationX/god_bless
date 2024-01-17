package faang.school.godbless.BJS2_1354;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TwitterAccount {

    private static List<String> usernames = new ArrayList<>();
    private int followers = 0;
    private String username;

    public TwitterAccount(String username) {
        if (usernames.contains(username)) {
            throw new IllegalArgumentException("Username is already in use, choose another one");
        }
        this.username = username;
        usernames.add(username);
    }

    public int addFollower() {
        return ++followers;
    }

    public int removeFollower() {
        return --followers;
    }
}