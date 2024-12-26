package school.faang.task_51003;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
public class TwitterAccount {

    private String username;
    private int followers;

    public TwitterAccount(String username, int followers) {
        if (username == null || username.isEmpty() || followers <= 0) {
            log.error("Username or Followers is empty");
            throw new IllegalArgumentException("Username or Followers is empty");
        }
        this.username = username;
        this.followers = followers;
    }

    public synchronized void addFollower() {
        followers += 1;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("TwitterAccount {username=");
        builder.append(username);
        builder.append(", followers=");
        builder.append(followers);
        builder.append("}");
        return builder.toString();
    }
}