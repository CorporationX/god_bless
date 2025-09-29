package school.faang.multithreading.async.bjs2_92975;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        TwitterAccount account1 = new TwitterAccount("Test Account 1");
        TwitterSubscriptionSystem twitterSubscriptionSystem = new TwitterSubscriptionSystem();

        List<Follower> users = List.of(
                new Follower("User 1"),
                new Follower("User 2"),
                new Follower("User 3")
        );

        twitterSubscriptionSystem.followAccount(account1, users);

    }
}
