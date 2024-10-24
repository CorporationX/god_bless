package school.faang.sprint_4.bjs2_38983_twitterCelebrity.account_manager;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;


@Slf4j
public class AccountManager {
    private static final Map<String, TwitterAccount> UNIQUE_ACCOUNTS = new ConcurrentHashMap<>();

    public void createTwitterAccount(String username) {
        if (UNIQUE_ACCOUNTS.putIfAbsent(username, new TwitterAccount(username)) == null) {
            log.info("Account {} successfully created.", username);
        } else {
            log.info("WRONG! Username {} already used.", username);
        }
    }

    public void follow(TwitterAccount follower, TwitterAccount target) {
        String followerUserName = getAccountUsername(follower);
        String targetUsername = getAccountUsername(target);

        if (target.addFollower(follower)) {
            log.info("{} followed {}.", followerUserName, targetUsername);
            log.info("{} now has {} followers", targetUsername, getFollowersCount(target));
        } else {
            log.info("You already following {}.", targetUsername);
        }
    }

    public String getAccountUsername(TwitterAccount account) {
        return account.getUsername();
    }

    public long getFollowersCount(TwitterAccount account) {
        return account.getFollowers().size();
    }

    public Set<TwitterAccount> getAllAccounts() {
        return Set.copyOf(UNIQUE_ACCOUNTS.values());
    }
}
