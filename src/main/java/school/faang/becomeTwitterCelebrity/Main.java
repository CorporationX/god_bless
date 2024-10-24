package school.faang.becomeTwitterCelebrity;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        TwitterSubscriptionSystem system = new TwitterSubscriptionSystem();
        List<TwitterAccount> accounts = List.of(
                new TwitterAccount("Duane Rock Johnson"),
                new TwitterAccount("Katty Perry"),
                new TwitterAccount("Snoop Dog")
        );

        for (TwitterAccount account : accounts) {
            system.followAccount(account);
            system.followAccount(accounts.get(0));
        }
        System.out.println("Total subscribers for each account: ");
        accounts.forEach(account ->
                System.out.println(account.getUsername() + " has " + account.getFollowers() + " subscribers."));
    }
}
