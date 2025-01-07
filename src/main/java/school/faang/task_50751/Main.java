package school.faang.task_50751;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TwitterSubscriptionSystem twitterSubscriptionSystem = new TwitterSubscriptionSystem();
        TwitterAccount twitterAccount = new TwitterAccount("Apple");
        List<User> usersAccount = new ArrayList<>();
        addUsersToFollow(usersAccount);
        twitterSubscriptionSystem.followAccount(twitterAccount, usersAccount);
    }

    private static void addUsersToFollow(List<User> usersAccount) {
        for (int i = 0; i < 10; i++) {
            usersAccount.add(new User(String.format("User_%d", i)));
        }
    }
}
