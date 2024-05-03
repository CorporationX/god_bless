package faang.school.godbless.twitter_celebrity;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        TwitterAccount max = new TwitterAccount("Max", 50);
        TwitterAccount bob = new TwitterAccount("Bob", 37);

        TwitterSubscriptionSystem subscriptionSystem = new TwitterSubscriptionSystem();

        CompletableFuture<Void> followTask1 = subscriptionSystem.followAccount(max);
        CompletableFuture<Void> followTask2 = subscriptionSystem.followAccount(bob);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(followTask1, followTask2);
        allTasks.join();

        System.out.println("Подписчиков у " + max.getUsername() + ": " + max.getFollowers());
        System.out.println("Подписчиков у " + bob.getUsername() + ": " + bob.getFollowers());
    }
}
