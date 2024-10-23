package school.faang.sprint_4.bjs2_38983_twitterCelebrity.account_manager;

import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Slf4j
@EqualsAndHashCode
public class TwitterAccount {
    private final String username;
    private final List<TwitterAccount> followers = new CopyOnWriteArrayList<>();

    TwitterAccount(String username) {
        this.username = username;
    }

    boolean addFollower(TwitterAccount account) {
        if (!followers.contains(account)) {
            followers.add(account);
            return true;
        }
        return false;
    }

    String getUsername() {
        return username;
    }

    List<TwitterAccount> getFollowers() {
        return List.copyOf(followers);
    }
}
