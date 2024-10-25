package school.faang.twitter;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        TwitterSubscriptionSystem subscriptionSystem = new TwitterSubscriptionSystem();
        TwitterAccount account1 = new TwitterAccount("Dimasik", 189);
        TwitterAccount account2 = new TwitterAccount("Timofey", 254);
        TwitterAccount account3 = new TwitterAccount("Maksim", 1321);

        CompletableFuture<Void> task1 = subscriptionSystem.followAccount(account1);
        CompletableFuture<Void> task2 = subscriptionSystem.followAccount(account2);
        CompletableFuture<Void> task3 = subscriptionSystem.followAccount(account3);

        CompletableFuture.allOf(task1, task2, task3);

        subscriptionSystem.shutdown();
    }
}
