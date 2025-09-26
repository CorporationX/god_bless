package bjs293013;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        TwitterSubscriptionSystem system = new TwitterSubscriptionSystem();
        TwitterAccount account = new TwitterAccount("seleba_twitter", 0);
        List<CompletableFuture<TwitterAccount>> futures = List.of(
                system.followAccount(account),
                system.followAccount(account),
                system.followAccount(account)
        );

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        System.out.println("Followers: " + account.getFollowers());
    }
}
