package dima.evseenko.twitter;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        TwitterSubscriptionSystem subscriptionSystem = new TwitterSubscriptionSystem();

        TwitterAccount account1 = new TwitterAccount("dima", 2);
        TwitterAccount account2 = new TwitterAccount("Vasya", 1);
        TwitterAccount account3 = new TwitterAccount("Petya", 0);

        CompletableFuture<TwitterAccount> future1 = subscriptionSystem.followAccount(account1);
        CompletableFuture<TwitterAccount> future2 = subscriptionSystem.followAccount(account2);
        CompletableFuture<TwitterAccount> future3 = subscriptionSystem.followAccount(account3);

        CompletableFuture.allOf(future1, future2, future3).thenAccept((Void aVoid)->{
            System.out.println(future1.join());
            System.out.println(future2.join());
            System.out.println(future3.join());
        });
    }
}
