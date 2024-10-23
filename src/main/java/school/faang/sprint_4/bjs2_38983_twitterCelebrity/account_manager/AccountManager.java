package school.faang.sprint_4.bjs2_38983_twitterCelebrity.account_manager;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@Slf4j
public class AccountManager {
    private static final Set<String> USED_USERNAMES = ConcurrentHashMap.newKeySet();
    private static final List<TwitterAccount> ACCOUNTS = new CopyOnWriteArrayList<>();

    public void createTwitterAccount(String username) {
        if (USED_USERNAMES.add(username)) {
            log.info("Account {} successfully created.", username);
            ACCOUNTS.add(new TwitterAccount(username));
        } else {
            log.info("Username '{}' already used.", username);
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

    public List<TwitterAccount> getAllAccounts() {
        return List.copyOf(ACCOUNTS);
    }
}
