package faang.school.godbless;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        TwitterAccount account = new TwitterAccount("Adil", 0);
        TwitterSubscriptionSystem subscriptionSystem = new TwitterSubscriptionSystem();

        CompletableFuture<Void> task1 = subscriptionSystem.followAccount(account);
        CompletableFuture<Void> task2 = subscriptionSystem.followAccount(account);
        CompletableFuture<Void> task3 = subscriptionSystem.followAccount(account);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(task1, task2, task3);
        allTasks.thenRun(() -> {
            System.out.println("Quantity of followers: " + account.getFollowers());
        }).join();
    }
}
