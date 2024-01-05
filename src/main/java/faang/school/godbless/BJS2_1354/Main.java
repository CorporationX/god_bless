package faang.school.godbless.BJS2_1354;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        TwitterSubscriptionSystem subscriptionSystem = new TwitterSubscriptionSystem();

        TwitterAccount account1 = new TwitterAccount("user1");
        TwitterAccount account2 = new TwitterAccount("user2");
        TwitterAccount account3 = new TwitterAccount("user3");

        ExecutorService executor = Executors.newFixedThreadPool(3);

        CompletableFuture<Void> follow1 = subscriptionSystem.followAccount(account1, executor);
        CompletableFuture<Void> follow2 = subscriptionSystem.followAccount(account2, executor);
        CompletableFuture<Void> follow3 = subscriptionSystem.followAccount(account3, executor);

        CompletableFuture<Void> allOf = CompletableFuture.allOf(follow1, follow2, follow3);
        allOf.thenRun(() -> {
            System.out.println("Followers for account1: " + account1.getFollowers());
            System.out.println("Followers for account2: " + account2.getFollowers());
            System.out.println("Followers for account3: " + account3.getFollowers());
        }).join();
    }
}