package faang.school.godbless.twitter;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {
        TwitterAccount account1 = new TwitterAccount("Ali_2002", 22);
        TwitterAccount account2 = new TwitterAccount("Alex_500", 52);
        TwitterAccount account3 = new TwitterAccount("David", 52);
        List<TwitterAccount> accounts = List.of(
                account1,
                account2,
                account3
        );
        TwitterSubscriptionSystem twitterSubscriptionSystem = new TwitterSubscriptionSystem();
        accounts.forEach(account -> {
            try {
                twitterSubscriptionSystem.followAccount(account);
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
