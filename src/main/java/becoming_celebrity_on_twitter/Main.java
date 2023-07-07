package becoming_celebrity_on_twitter;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        TwitterAccount elonmusk = new TwitterAccount("@elonmusk");
        TwitterAccount ladygaga = new TwitterAccount("@ladygaga");

        TwitterSubscriptionSystem subscriptionSystem = new TwitterSubscriptionSystem();

        CompletableFuture<Void> task1 = subscriptionSystem.followAccount(elonmusk);
        CompletableFuture<Void> task2 = subscriptionSystem.followAccount(ladygaga);
        CompletableFuture<Void> task3 = subscriptionSystem.followAccount(elonmusk);
        CompletableFuture<Void> task4 = subscriptionSystem.followAccount(elonmusk);
        CompletableFuture<Void> task5 = subscriptionSystem.followAccount(ladygaga);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(task1, task2, task3, task4, task5);
        allTasks.thenRun(() -> {
            System.out.println("\nAll tasks completed\n");
            System.out.println("The number of subscribers of the account " + elonmusk.getUsername() +
                    " is " + elonmusk.getFollowers());
            System.out.println("The number of subscribers of the account " + ladygaga.getUsername() +
                    " is " + ladygaga.getFollowers());
        });

        allTasks.join();
    }
}
