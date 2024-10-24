package school.faang.sprint_4.bjs2_38983_twitterCelebrity.account_manager;

import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class TwitterAccount {
    @EqualsAndHashCode.Include
    private final String username;
    private final Set<TwitterAccount> followers = ConcurrentHashMap.newKeySet();

    TwitterAccount(String username) {
        this.username = username;
    }

    boolean addFollower(TwitterAccount account) {
        return followers.add(account);
    }

    String getUsername() {
        return username;
    }

    Set<TwitterAccount> getFollowers() {
        return Set.copyOf(followers);
    }
}
