package BecomingTwitterCelebrity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        List<TwitterAccount> accounts = Arrays.asList(
                new TwitterAccount("Bob", 0),
                new TwitterAccount("Rod", 0),
                new TwitterAccount("Sam", 0));
        TwitterSubscriptionSystem subscriptionSystem = new TwitterSubscriptionSystem();
        List<CompletableFuture<Void>> allFutureOrders = new ArrayList<>();

        accounts.forEach(twitterAccount -> {
            for (int i = 0; i < 1000; i++) {
                allFutureOrders.add(subscriptionSystem.followAccount(twitterAccount));
            }
        });

        CompletableFuture.allOf(allFutureOrders.toArray(new CompletableFuture[0])).join();
        accounts.forEach(account -> System.out.println(account.getUsername() + ": " + account.getFollowers()));
    }
}